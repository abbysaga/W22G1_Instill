package com.instill.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.instill.R;

import java.io.File;

public class PDFViewerActivity extends AppCompatActivity {
    PDFView pdfViewer;
    private boolean needAnalysis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);

        pdfViewer = findViewById(R.id.pdfViewer);
        if (getIntent() != null) {
            if (getIntent().hasExtra("file"))
                loadPDFFile();
            needAnalysis = getIntent().hasExtra("needAnalysis") && getIntent().getBooleanExtra("needAnalysis", false);
            findViewById(R.id.linBtns).setVisibility(needAnalysis ? View.VISIBLE : View.GONE);
        } else {
            Toast.makeText(this, "File not found. Exiting the activity", Toast.LENGTH_SHORT).show();
            finish();
        }

        findViewById(R.id.imageViewBack).setOnClickListener(view -> onBackPressed());
        findViewById(R.id.btnShowAnalysis).setOnClickListener(view -> {
            navigateToAnalysis(true);
        });
        findViewById(R.id.btnSearchJobsInYourArea).setOnClickListener(view -> {
            navigateToAnalysis(false);
        });

    }

    private void navigateToAnalysis(boolean needAnalysis) {
        Intent intent = new Intent(this, AnalysisActivity.class);
        intent.putExtra("needAnalysis", needAnalysis);
        intent.putIntegerArrayListExtra("skillsIds", getIntent().getIntegerArrayListExtra("skillsIds"));
        startActivity(intent);
    }

    private void loadPDFFile() {
        File file = (File) getIntent().getSerializableExtra("file");
        pdfViewer.fromFile(file)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false)
                .password(null)
                .enableAntialiasing(true)
                .spacing(0)
                .load();
        ((TextView) findViewById(R.id.txtHeading)).setText(file.getName().substring(0, file.getName().lastIndexOf('.')));
    }

}