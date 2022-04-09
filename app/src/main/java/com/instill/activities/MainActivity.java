package com.instill.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.instill.R;
import com.instill.adapters.FilesAdapter;
import com.instill.utils.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewFiles;
    List<File> fileList;
    TextView txtNoData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewFiles = findViewById(R.id.recyclerView);
        txtNoData = findViewById(R.id.txtNoData);
        fileList = new ArrayList<>();
        findViewById(R.id.createNewResume).setOnClickListener(view -> startActivity(new Intent(MainActivity.this, CreateResumeActivity.class)));
//        findViewById(R.id.createNewResume).setOnClickListener(view -> navigateToAnalysis(false));
    }

    @Override
    protected void onStart() {
        super.onStart();
        fileList = Utils.getAllAppPDFFiles();
        if (fileList.isEmpty()) {
            recyclerViewFiles.setVisibility(View.GONE);
            txtNoData.setVisibility(View.VISIBLE);
        } else {
            txtNoData.setVisibility(View.GONE);
            recyclerViewFiles.setVisibility(View.VISIBLE);
            setUpAdapter();
        }
    }

    private void navigateToAnalysis(boolean needAnalysis) {
//        This is for testing only
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        Intent intent = new Intent(this, AnalysisActivity.class);
        intent.putExtra("needAnalysis", needAnalysis);
        intent.putIntegerArrayListExtra("skillsIds", integers);
        startActivity(intent);
    }

    private void setUpAdapter() {
        try {
            recyclerViewFiles.setLayoutManager(new LinearLayoutManager(this));
            FilesAdapter filesAdapter = new FilesAdapter(fileList, (position, view) -> {
                Intent intent = new Intent(MainActivity.this, PDFViewerActivity.class);
                intent.putExtra("file", fileList.get(position));
                startActivity(intent);
            });
            recyclerViewFiles.setAdapter(filesAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}