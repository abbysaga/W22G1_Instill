package com.instill.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.instill.R;
import com.instill.adapters.DialogRecyclerViewAdapter;
import com.instill.database.dbmodels.SkillsModel;
import com.instill.databinding.ActivityCreateResumeBinding;
import com.instill.models.EducationDetails;
import com.instill.models.Experience;
import com.instill.models.PersonalDetails;
import com.instill.models.Project;
import com.instill.utils.DialogUtils;
import com.instill.utils.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CreateResumeActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityCreateResumeBinding activityCreateResumeBinding;
    private PersonalDetails personalDetails;

    private ArrayList<EducationDetails> educationDetailsArrayList;
    private ArrayList<Experience> experienceArrayList;
    private ArrayList<SkillsModel> skillArrayList;
    private ArrayList<Project> projectArrayList;
    private List<String> listOfStrings;

    private String heading;
    private DialogRecyclerViewAdapter dialogRecyclerViewAdapter = null;

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCreateResumeBinding = DataBindingUtil.setContentView(this, R.layout.activity_create_resume);
        initComponents();
    }

    private void initComponents() {
//        personalDetails = new PersonalDetails();
        educationDetailsArrayList = new ArrayList<>();
        experienceArrayList = new ArrayList<>();
        skillArrayList = new ArrayList<>();
        projectArrayList = new ArrayList<>();

        activityCreateResumeBinding.imageViewBack.setOnClickListener(this);
        activityCreateResumeBinding.txtPersonalDetailsLable.setOnClickListener(this);
        activityCreateResumeBinding.txtEducationalDetailsLable.setOnClickListener(this);
        activityCreateResumeBinding.txtExperienceDetailsLable.setOnClickListener(this);
        activityCreateResumeBinding.txtSkillsLable.setOnClickListener(this);
        activityCreateResumeBinding.txtProjectsLable.setOnClickListener(this);
        activityCreateResumeBinding.btnProceed.setOnClickListener(this);
        activityCreateResumeBinding.imageViewExperienceDetails.setOnClickListener(this);
        activityCreateResumeBinding.imageViewEducationalDetails.setOnClickListener(this);
        activityCreateResumeBinding.imageViewPersonalDetails.setOnClickListener(this);
        activityCreateResumeBinding.imageViewSkills.setOnClickListener(this);
        activityCreateResumeBinding.imageViewProjects.setOnClickListener(this);
    }

    private void updateDataInViews() {
        updateDataInPersonal();
        updateDataInEducation();
        updateDataInExperience();
        updateDataInSkills();
        updateDataInProjects();
    }

    private void updateDataInPersonal() {
        if (personalDetails != null && !TextUtils.isEmpty(personalDetails.firstName))
            activityCreateResumeBinding.txtPersonalDetails.setText(personalDetails.toString());
        else
            activityCreateResumeBinding.txtPersonalDetails.setText("Click on Edit button to add Personal details");
    }

    private void updateDataInEducation() {
        if (!educationDetailsArrayList.isEmpty()) {
            String educationDetailsString = "";
            for (EducationDetails educationDetails : educationDetailsArrayList) {
                educationDetailsString += educationDetails.toString();
                educationDetailsString += "\n";
            }
            educationDetailsString = educationDetailsString.substring(0, educationDetailsString.length() - 1);
            activityCreateResumeBinding.txtEducationalDetails.setText(educationDetailsString);
        } else
            activityCreateResumeBinding.txtEducationalDetails.setText("Click on Edit button to add Educational details");
    }

    private void updateDataInExperience() {
        if (!experienceArrayList.isEmpty()) {
            String experienceString = "";
            for (Experience experience : experienceArrayList) {
                experienceString += (experience.toString() + "\n");
            }
            experienceString = experienceString.substring(0, experienceString.length() - 1);
            activityCreateResumeBinding.txtExperienceDetails.setText(experienceString);
        } else
            activityCreateResumeBinding.txtExperienceDetails.setText("Click on Edit button to add Past Work Experiences");
    }

    private void updateDataInSkills() {
        if (!skillArrayList.isEmpty()) {
            String skillsString = "";
            for (SkillsModel skill : skillArrayList) {
                skillsString += (skill.toString() + "\n");
            }
            skillsString = skillsString.substring(0, skillsString.length() - 1);
            activityCreateResumeBinding.txtSkills.setText(skillsString);
        } else
            activityCreateResumeBinding.txtSkills.setText("Click on Edit button to add Your Skills");
    }

    private void updateDataInProjects() {
        if (!projectArrayList.isEmpty()) {
            String projectsString = "";
            for (Project project : projectArrayList) {
                projectsString += (project.toString() + "\n");
            }
            projectsString = projectsString.substring(0, projectsString.length() - 1);
            activityCreateResumeBinding.txtProjects.setText(projectsString);
        } else
            activityCreateResumeBinding.txtProjects.setText("Click on Edit button to add Projects");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageViewBack:
                onBackPressed();
                break;
            case R.id.txtPersonalDetailsLable:
                if (activityCreateResumeBinding.linPersonalDetails.getVisibility() == View.VISIBLE) {
                    activityCreateResumeBinding.linPersonalDetails.setVisibility(View.GONE);
                    activityCreateResumeBinding.txtPersonalDetailsLable.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_profile, 0, R.drawable.ic_down, 0);
                } else {
                    activityCreateResumeBinding.linPersonalDetails.setVisibility(View.VISIBLE);
                    activityCreateResumeBinding.txtPersonalDetailsLable.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_profile, 0, R.drawable.ic_up, 0);
                    updateDataInPersonal();
                }
                break;
            case R.id.txtEducationalDetailsLable:
                if (activityCreateResumeBinding.linEducationalDetails.getVisibility() == View.VISIBLE) {
                    activityCreateResumeBinding.linEducationalDetails.setVisibility(View.GONE);
                    activityCreateResumeBinding.txtEducationalDetailsLable.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_education, 0, R.drawable.ic_down, 0);
                } else {
                    activityCreateResumeBinding.linEducationalDetails.setVisibility(View.VISIBLE);
                    activityCreateResumeBinding.txtEducationalDetailsLable.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_education, 0, R.drawable.ic_up, 0);
                    updateDataInEducation();
                }
                break;
            case R.id.txtExperienceDetailsLable:
                if (activityCreateResumeBinding.linExperienceDetails.getVisibility() == View.VISIBLE) {
                    activityCreateResumeBinding.linExperienceDetails.setVisibility(View.GONE);
                    activityCreateResumeBinding.txtExperienceDetailsLable.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_work, 0, R.drawable.ic_down, 0);
                } else {
                    activityCreateResumeBinding.linExperienceDetails.setVisibility(View.VISIBLE);
                    activityCreateResumeBinding.txtExperienceDetailsLable.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_work, 0, R.drawable.ic_up, 0);
                    updateDataInExperience();
                }
                break;
            case R.id.txtSkillsLable:
                if (activityCreateResumeBinding.linSkills.getVisibility() == View.VISIBLE) {
                    activityCreateResumeBinding.linSkills.setVisibility(View.GONE);
                    activityCreateResumeBinding.txtSkillsLable.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_skill, 0, R.drawable.ic_down, 0);
                } else {
                    activityCreateResumeBinding.linSkills.setVisibility(View.VISIBLE);
                    activityCreateResumeBinding.txtSkillsLable.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_skill, 0, R.drawable.ic_up, 0);
                    updateDataInSkills();
                }
                break;
            case R.id.txtProjectsLable:
                if (activityCreateResumeBinding.linProjects.getVisibility() == View.VISIBLE) {
                    activityCreateResumeBinding.linProjects.setVisibility(View.GONE);
                    activityCreateResumeBinding.txtProjectsLable.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_project, 0, R.drawable.ic_down, 0);
                } else {
                    activityCreateResumeBinding.linProjects.setVisibility(View.VISIBLE);
                    activityCreateResumeBinding.txtProjectsLable.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_project, 0, R.drawable.ic_up, 0);
                    updateDataInProjects();
                }
                break;
            case R.id.imageViewPersonalDetails:
                DialogUtils.showPersonalDetailsDialog(this, personalDetails, item -> {
                    personalDetails = (PersonalDetails) item;
                    updateDataInPersonal();
                });
                break;
            case R.id.imageViewEducationalDetails:
                openListDialog(Utils.EDUCATION);
                break;
            case R.id.imageViewExperienceDetails:
                openListDialog(Utils.EXPERIENCE);
                break;
            case R.id.imageViewSkills:
                openListDialog(Utils.SKILLS);
                break;
            case R.id.imageViewProjects:
                openListDialog(Utils.PROJECTS);
                break;
            case R.id.btnProceed:
                String message = checkValidations();
                if (TextUtils.isEmpty(message)) {
                    createResumePDF();
                } else {
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }

    private String checkValidations() {
        String messageToDisplay = "";
        if (personalDetails == null || TextUtils.isEmpty(personalDetails.lastName))
            messageToDisplay = "Please add Personal Details";
        else if (educationDetailsArrayList.isEmpty())
            messageToDisplay = "Please add Education Details";
        else if (experienceArrayList.isEmpty())
            messageToDisplay = "Please add Experience Details";
        else if (skillArrayList.isEmpty())
            messageToDisplay = "Please add Skills";
        else if (projectArrayList.isEmpty())
            messageToDisplay = "Please add Projects";
        return messageToDisplay;
    }

    private void openListDialog(int position) {
        heading = getString(R.string.app_name);
        listOfStrings = updateList(position);

        Dialog dialog = new Dialog(this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_recycler);

        TextView txtHeading = dialog.findViewById(R.id.txtHeading);
        txtHeading.setText(heading);
        Button btnDismiss = dialog.findViewById(R.id.btnDismiss);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);

        TextView txtNoData = dialog.findViewById(R.id.txtNoData);
        RecyclerView recyclerView = dialog.findViewById(R.id.recyclerView);

        btnDismiss.setOnClickListener(v -> dialog.dismiss());
        btnAdd.setOnClickListener(v -> {
            switch (position) {
                case Utils.EDUCATION:
                    DialogUtils.showAddEducationDialog(this, null, item -> {
                        if (item != null) {
                            if (educationDetailsArrayList.contains(item)) {
                                educationDetailsArrayList.remove(item);
                            }
                            educationDetailsArrayList.add((EducationDetails) item);
                            listOfStrings = updateList(position);

                            if (dialogRecyclerViewAdapter != null)
                                dialogRecyclerViewAdapter.updateList(listOfStrings);
                            if (listOfStrings.isEmpty()) {
                                txtNoData.setVisibility(View.VISIBLE);
                                recyclerView.setVisibility(View.GONE);
                            } else {
                                txtNoData.setVisibility(View.GONE);
                                recyclerView.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                    break;
                case Utils.EXPERIENCE:
                    DialogUtils.showAddExperienceDialog(this, null, item -> {
                        if (item != null) {
                            if (experienceArrayList.contains(item)) {
                                experienceArrayList.remove(item);
                            }
                            experienceArrayList.add((Experience) item);
                            listOfStrings = updateList(position);
                            if (dialogRecyclerViewAdapter != null)
                                dialogRecyclerViewAdapter.updateList(listOfStrings);
                            if (listOfStrings.isEmpty()) {
                                txtNoData.setVisibility(View.VISIBLE);
                                recyclerView.setVisibility(View.GONE);
                            } else {
                                txtNoData.setVisibility(View.GONE);
                                recyclerView.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                    break;
                case Utils.SKILLS:
                    DialogUtils.showAddSkillDialog(this, null, item -> {
                        if (item != null) {
                            if (skillArrayList.contains(item)) {
                                skillArrayList.remove(item);
                            }
                            skillArrayList.add((SkillsModel) item);
                            listOfStrings = updateList(position);
                            if (dialogRecyclerViewAdapter != null)
                                dialogRecyclerViewAdapter.updateList(listOfStrings);
                            if (listOfStrings.isEmpty()) {
                                txtNoData.setVisibility(View.VISIBLE);
                                recyclerView.setVisibility(View.GONE);
                            } else {
                                txtNoData.setVisibility(View.GONE);
                                recyclerView.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                    break;
                case Utils.PROJECTS:
                    DialogUtils.showAddProjectsDialog(this, null, item -> {
                        if (item != null) {
                            if (projectArrayList.contains(item)) {
                                projectArrayList.remove(item);
                            }
                            projectArrayList.add((Project) item);
                            listOfStrings = updateList(position);
                            if (dialogRecyclerViewAdapter != null)
                                dialogRecyclerViewAdapter.updateList(listOfStrings);
                            if (listOfStrings.isEmpty()) {
                                txtNoData.setVisibility(View.VISIBLE);
                                recyclerView.setVisibility(View.GONE);
                            } else {
                                txtNoData.setVisibility(View.GONE);
                                recyclerView.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                    break;
                default:
                    break;
            }
        });

        if (listOfStrings.isEmpty()) {
            txtNoData.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            txtNoData.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dialogRecyclerViewAdapter = new DialogRecyclerViewAdapter(listOfStrings, (position1, view) -> {
            switch (position) {
                case Utils.EDUCATION:
                    if (view.getId() == R.id.imgEdit) {
                        DialogUtils.showAddEducationDialog(this, educationDetailsArrayList.get(position1), item -> {
                            if (item != null) {
                                if (educationDetailsArrayList.contains(item)) {
                                    educationDetailsArrayList.remove(item);
                                }
                                educationDetailsArrayList.add((EducationDetails) item);
                            }
                        });
                    } else if (view.getId() == R.id.imgRemove) {
                        educationDetailsArrayList.remove(position1);
                    }
                    break;
                case Utils.EXPERIENCE:
                    if (view.getId() == R.id.imgEdit) {
                        DialogUtils.showAddExperienceDialog(this, experienceArrayList.get(position1), item -> {
                            if (item != null) {
                                if (experienceArrayList.contains(item)) {
                                    experienceArrayList.remove(item);
                                }
                                experienceArrayList.add((Experience) item);
                            }
                        });
                    } else if (view.getId() == R.id.imgRemove) {
                        experienceArrayList.remove(position1);
                    }
                    break;
                case Utils.SKILLS:
                    if (view.getId() == R.id.imgEdit) {
                        DialogUtils.showAddSkillDialog(this, skillArrayList.get(position1), item -> {
                            if (item != null) {
                                if (skillArrayList.contains(item)) {
                                    skillArrayList.remove(item);
                                }
                                skillArrayList.add((SkillsModel) item);
                            }
                        });
                    } else if (view.getId() == R.id.imgRemove) {
                        skillArrayList.remove(position1);
                    }
                    break;
                case Utils.PROJECTS:
                    if (view.getId() == R.id.imgEdit) {
                        DialogUtils.showAddProjectsDialog(this, projectArrayList.get(position1), item -> {
                            if (item != null) {
                                if (projectArrayList.contains(item)) {
                                    projectArrayList.remove(item);
                                }
                                projectArrayList.add((Project) item);
                            }
                        });
                    } else if (view.getId() == R.id.imgRemove) {
                        projectArrayList.remove(position1);
                    }
                    break;
                default:
                    break;
            }
            listOfStrings = updateList(position);
            if (dialogRecyclerViewAdapter != null)
                dialogRecyclerViewAdapter.notifyDataSetChanged();
            if (listOfStrings.isEmpty()) {
                txtNoData.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            } else {
                txtNoData.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });
        recyclerView.setAdapter(dialogRecyclerViewAdapter);

        dialog.setOnDismissListener(dialogInterface -> {
            updateDataInViews();
        });

        dialog.show();
    }

    private List<String> updateList(int position) {
        List<String> listOfStrings = new ArrayList<>();
        switch (position) {
            case Utils.EDUCATION:
                heading = "Education Details";
                for (EducationDetails educationDetail : educationDetailsArrayList) {
                    listOfStrings.add(educationDetail.toString());
                }
                break;
            case Utils.EXPERIENCE:
                heading = "Experience";
                for (Experience experience : experienceArrayList) {
                    listOfStrings.add(experience.toString());
                }
                break;
            case Utils.SKILLS:
                heading = "Skills";
                for (SkillsModel skill : skillArrayList) {
                    listOfStrings.add(skill.toString());
                }
                break;
            case Utils.PROJECTS:
                heading = "Projects";
                for (Project project : projectArrayList) {
                    listOfStrings.add(project.toString());
                }
                break;
            default:
                break;
        }
        return listOfStrings;
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "You will loose your data if you go back. Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler(Looper.getMainLooper()).postDelayed(() -> doubleBackToExitPressedOnce = false, 2000);
    }

    public void createResumePDF() {
        int pageWidth = 300;
//        int pageheight = 470;
//        Hardcoding to big size to accomodate more data
        int pageheight = 900;
        int pathHeight = 2;

        PdfDocument myPdfDocument = new PdfDocument();
        Paint textPaint = new Paint();
        Paint linePaint = new Paint();
        linePaint.setColor(Color.GRAY);
        linePaint.setStyle(Paint.Style.STROKE);

        Path path = new Path();
        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(pageWidth, pageheight, 1).create();
        PdfDocument.Page documentPage = myPdfDocument.startPage(myPageInfo);
        Canvas canvas = documentPage.getCanvas();

        int x = 10, y = 25;

        canvas.drawText("Resume for " + personalDetails.firstName + " " + personalDetails.middleName + " " + personalDetails.lastName, x, y, textPaint);
        y += textPaint.descent() - textPaint.ascent();
        y += 10;
        canvas.drawText(personalDetails.firstName + " " + personalDetails.middleName + " " + personalDetails.lastName, x, y, textPaint);
        y += textPaint.descent() - textPaint.ascent();
        canvas.drawText(personalDetails.emailAddress, x, y, textPaint);
        y += textPaint.descent() - textPaint.ascent();
        canvas.drawText(personalDetails.phoneNumber, x, y, textPaint);
        y += textPaint.descent() - textPaint.ascent();
        canvas.drawText(personalDetails.addressLine1, x, y, textPaint);
        y += textPaint.descent() - textPaint.ascent();
        canvas.drawText(personalDetails.province + " " + personalDetails.country, x, y, textPaint);
        y += textPaint.descent() - textPaint.ascent();
        canvas.drawText("LinkedIn: " + personalDetails.linkedInLink, x, y, textPaint);
        y += 10;

        //horizontal line
        path.lineTo(pageWidth, pathHeight);
        path.moveTo(x, y);
        canvas.drawLine(0, y, pageWidth, y, linePaint);

        y += 10;
        y += textPaint.descent() - textPaint.ascent();
        canvas.drawText("Education Details", x, y, textPaint);
        y += textPaint.descent() - textPaint.ascent();
        y += 10;

        for (EducationDetails educationDetails : educationDetailsArrayList) {
            canvas.drawText(educationDetails.university, x, y, textPaint);
            y += textPaint.descent() - textPaint.ascent();
            canvas.drawText(educationDetails.degree, x, y, textPaint);
            y += textPaint.descent() - textPaint.ascent();
            canvas.drawText("Graduated with Grade: " + educationDetails.grade, x, y, textPaint);
            y += textPaint.descent() - textPaint.ascent();
            canvas.drawText("Graduation year: " + educationDetails.year, x, y, textPaint);
            y += textPaint.descent() - textPaint.ascent();
            y += 10;
        }

        y += 10;
        path.lineTo(pageWidth, pathHeight);
        path.moveTo(x, y);
        canvas.drawLine(0, y, pageWidth, y, linePaint);

        y += 10;
        y += textPaint.descent() - textPaint.ascent();
        canvas.drawText("Experience", x, y, textPaint);
        y += textPaint.descent() - textPaint.ascent();
        y += 10;

        for (Experience experience : experienceArrayList) {
            canvas.drawText(experience.companyName, x, y, textPaint);
            y += textPaint.descent() - textPaint.ascent();
            canvas.drawText(experience.jobTitle, x, y, textPaint);
            y += textPaint.descent() - textPaint.ascent();
            canvas.drawText("From: " + experience.startDate + " To: " + experience.endDate, x, y, textPaint);
            y += textPaint.descent() - textPaint.ascent();
            canvas.drawText(experience.jobDescription, x, y, textPaint);
            y += textPaint.descent() - textPaint.ascent();
            y += 10;
        }

        y += 10;
        path.lineTo(pageWidth, pathHeight);
        path.moveTo(x, y);
        canvas.drawLine(0, y, pageWidth, y, linePaint);

        y += 10;
        y += textPaint.descent() - textPaint.ascent();
        canvas.drawText("Skills", x, y, textPaint);
        y += textPaint.descent() - textPaint.ascent();
        y += 10;

        for (SkillsModel skillsModel : skillArrayList) {
            canvas.drawText(skillsModel.getSkillName(), x, y, textPaint);
            y += textPaint.descent() - textPaint.ascent();
            canvas.drawText(skillsModel.getLevel(), x, y, textPaint);
            y += textPaint.descent() - textPaint.ascent();
            y += 10;
        }

        y += 10;
        path.lineTo(pageWidth, pathHeight);
        path.moveTo(x, y);
        canvas.drawLine(0, y, pageWidth, y, linePaint);

        y += 10;
        y += textPaint.descent() - textPaint.ascent();
        canvas.drawText("Projects", x, y, textPaint);
        y += textPaint.descent() - textPaint.ascent();
        y += 10;

        for (Project project : projectArrayList) {
            canvas.drawText(project.title, x, y, textPaint);
            y += textPaint.descent() - textPaint.ascent();
            canvas.drawText(project.description, x, y, textPaint);
            y += textPaint.descent() - textPaint.ascent();
            y += 10;
        }

        y += 10;
        path.lineTo(pageWidth, pathHeight);
        path.moveTo(x, y);
        canvas.drawLine(0, y, pageWidth, y, linePaint);

        myPdfDocument.finishPage(documentPage);

        File file = new File(Utils.AppFolderPath + "/" + personalDetails.lastName + "_Resume_" + Calendar.getInstance().getTimeInMillis() + ".pdf");

        try {
            myPdfDocument.writeTo(new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        myPdfDocument.close();

        Toast.makeText(CreateResumeActivity.this, "Created Resume. Analysing the data.", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(CreateResumeActivity.this, PDFViewerActivity.class);
            intent.putExtra("file", file);
            ArrayList<Integer> skillsIds = new ArrayList<>();
            for (SkillsModel skillsModel : skillArrayList) skillsIds.add(skillsModel.skillId);
            intent.putIntegerArrayListExtra("skillsIds", skillsIds);
            intent.putExtra("needAnalysis", true);
            startActivity(intent);
        }, 3000);
    }

}
