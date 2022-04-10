package com.instill.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.instill.R;
import com.instill.adapters.SuggestionsAdapter;
import com.instill.database.SkillEnhancerDatabase;
import com.instill.database.dbmodels.SkillsModel;
import com.instill.database.dbmodels.SuggestionsModel;
import com.instill.interfaces.RecyclerViewItemClick;
import com.instill.models.Suggestion;
import com.instill.utils.DataBaseUtil;
import com.instill.utils.GpsTracker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnalysisActivity extends AppCompatActivity implements RecyclerViewItemClick {

    private boolean needAnalysis;
    SkillEnhancerDatabase skillEnhancerDatabase;
    ArrayList<Integer> skillsIds;
    List<SuggestionsModel> suggestionsModelArrayList;
    List<Suggestion> suggestionsArrayList;
    List<SkillsModel> skillsModelList;
    private RecyclerView recyclerView;
    private GpsTracker gpsTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        recyclerView = findViewById(R.id.recyclerView);
        findViewById(R.id.imageViewBack).setOnClickListener(view -> onBackPressed());
        handleDataFromPreviousScreen();
        if (!needAnalysis) getLocationDetails();
    }

    private void getLocationDetails() {
        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            } else getLocation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        getLocationDetails();
    }

    public void getLocation() {
        gpsTracker = new GpsTracker(this);
        if (gpsTracker.canGetLocation()) {
            double latitude = gpsTracker.getLatitude();
            double longitude = gpsTracker.getLongitude();
            Toast.makeText(this, "You are at \nLatitude: " + latitude + "\nLongitude: " + longitude, Toast.LENGTH_SHORT).show();
        } else {
            gpsTracker.showSettingsAlert();
        }
    }

    private void handleDataFromPreviousScreen() {
        if (getIntent() != null) {
            skillsIds = new ArrayList<>();
            skillsModelList = new ArrayList<>();
            suggestionsModelArrayList = new ArrayList<>();
            suggestionsArrayList = new ArrayList<>();

            needAnalysis = getIntent().hasExtra("needAnalysis") && getIntent().getBooleanExtra("needAnalysis", false);
            skillsIds = getIntent().getIntegerArrayListExtra("skillsIds");

            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(() -> {
                try {
                    skillEnhancerDatabase = DataBaseUtil.getDatabaseInstance(this);
                    suggestionsModelArrayList = skillEnhancerDatabase.suggestionsDao().getSuggestionsForSkills(skillsIds);
                    skillsModelList = skillEnhancerDatabase.skillsModelDao().getSkillsWithIds(skillsIds);

                    if (needAnalysis) {
                        for (int i = 0; i < suggestionsModelArrayList.size(); i++) {
                            SuggestionsModel suggestionsModel = suggestionsModelArrayList.get(i);
                            for (SkillsModel skillsModel : skillsModelList) {
                                if (suggestionsModel.getSkillId() == skillsModel.skillId) {
                                    ArrayList<String> skillLinks = suggestionsModel.getSkillLinks();
                                    for (int j = 0, skillLinksSize = skillLinks.size(); j < skillLinksSize; j++) {
                                        String link = skillLinks.get(j);
                                        Suggestion suggestion = new Suggestion();
                                        suggestion.title = "Link " + (j + 1) + " for Suggested Courses: " + skillsModel.getSkillName();
                                        suggestion.link = link;
                                        suggestionsArrayList.add(suggestion);
                                    }
                                    break;
                                }
                            }
                        }
                    } else {
                        for (SkillsModel skillsModel : skillsModelList) {
                            Suggestion suggestion = new Suggestion();
                            suggestion.title = "Job Bank Link for " + skillsModel.getSkillName();
                            suggestion.link = "https://www.jobbank.gc.ca/jobsearch/jobsearch?searchstring=skillToSearch&locationstring=V5W3H3".replace("skillToSearch", skillsModel.getSkillName());
                            suggestionsArrayList.add(suggestion);

                            suggestion = new Suggestion();
                            suggestion.title = "Work BC Link for " + skillsModel.getSkillName();
                            suggestion.link = "https://www.workbc.ca/jobs-careers/find-jobs/jobs.aspx#/job-search;search=skillToSearch;city=Vancouver".replace("skillToSearch", skillsModel.getSkillName());
                            suggestionsArrayList.add(suggestion);
                        }
                    }
                    runOnUiThread(this::setUpRecyclerViewForLinks);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        }
    }

    private void setUpRecyclerViewForLinks() {
        SuggestionsAdapter suggestionsAdapter = new SuggestionsAdapter(suggestionsArrayList, this);
        recyclerView.setAdapter(suggestionsAdapter);
    }

    @Override
    public void onItemClick(int position, View view) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("suggestion", suggestionsArrayList.get(position));
        startActivity(intent);
    }

}