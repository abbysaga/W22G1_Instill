package com.instill.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import com.instill.R;
import com.instill.database.dbmodels.Courses;
import com.instill.database.dbmodels.SkillsModel;
import com.instill.interfaces.DialogClickListeners;
import com.instill.models.EducationDetails;
import com.instill.models.Experience;
import com.instill.models.PersonalDetails;
import com.instill.models.Project;

import java.util.ArrayList;
import java.util.List;

public class DialogUtils {

    private static List<SkillsModel> skillsModelArrayList;

    public static void showPersonalDetailsDialog(Context context, @Nullable PersonalDetails personalDetails,
                                                 DialogClickListeners dialogClickListener) {
        Dialog dialog = new Dialog(context);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.form_personal_details);

        Button btnDismiss = dialog.findViewById(R.id.btnDismiss);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);

        EditText edtFirstName = dialog.findViewById(R.id.edtFirstName);
        EditText edtMiddleName = dialog.findViewById(R.id.edtMiddleName);
        EditText edtLastName = dialog.findViewById(R.id.edtLastName);
        EditText edtEmailAddress = dialog.findViewById(R.id.edtEmailAddress);
        EditText edtLinkedIn = dialog.findViewById(R.id.edtLinkedIn);
        EditText edtAddress1 = dialog.findViewById(R.id.edtAddress1);
        EditText edtState = dialog.findViewById(R.id.edtState);
        EditText edtCountry = dialog.findViewById(R.id.edtCountry);
        EditText edtPhoneNumber = dialog.findViewById(R.id.edtPhoneNumber);

        if (personalDetails != null) {
            edtFirstName.setText(personalDetails.firstName);
            edtMiddleName.setText(personalDetails.middleName);
            edtLastName.setText(personalDetails.lastName);
            edtEmailAddress.setText(personalDetails.emailAddress);
            edtLinkedIn.setText(personalDetails.linkedInLink);
            edtAddress1.setText(personalDetails.addressLine1);
            edtState.setText(personalDetails.province);
            edtCountry.setText(personalDetails.country);
            edtPhoneNumber.setText(personalDetails.phoneNumber);
        }

        btnDismiss.setOnClickListener(v -> dialog.dismiss());
        btnAdd.setOnClickListener(v -> {
//            check validations before adding data
            PersonalDetails personalDetail = new PersonalDetails();
            personalDetail.firstName = edtFirstName.getText().toString().trim();
            personalDetail.middleName = edtMiddleName.getText().toString().trim();
            personalDetail.lastName = edtLastName.getText().toString().trim();
            personalDetail.emailAddress = edtEmailAddress.getText().toString().trim();
            personalDetail.linkedInLink = edtLinkedIn.getText().toString().trim();
            personalDetail.addressLine1 = edtAddress1.getText().toString().trim();
            personalDetail.province = edtState.getText().toString().trim();
            personalDetail.country = edtCountry.getText().toString().trim();
            personalDetail.phoneNumber = edtPhoneNumber.getText().toString().trim();
            dialogClickListener.onItemClick(personalDetail);
            dialog.dismiss();
        });
        dialog.show();
    }

    public static void showAddEducationDialog(Context context, @Nullable EducationDetails educationDetails,
                                              DialogClickListeners dialogClickListener) {
        Dialog dialog = new Dialog(context);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.form_education);

        Button btnDismiss = dialog.findViewById(R.id.btnDismiss);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);

        EditText edtUniversity = dialog.findViewById(R.id.edtUniversity);
        EditText edtDegree = dialog.findViewById(R.id.edtDegree);
        EditText edtGrade = dialog.findViewById(R.id.edtGrade);
        EditText edtYear = dialog.findViewById(R.id.edtYear);

        if (educationDetails != null) {
            edtUniversity.setText(educationDetails.university);
            edtDegree.setText(educationDetails.degree);
            edtGrade.setText(educationDetails.grade);
            edtYear.setText(educationDetails.year);
        }
        btnDismiss.setOnClickListener(v -> dialog.dismiss());
        btnAdd.setOnClickListener(v -> {
//            check validations before adding data
            EducationDetails educationDetail = new EducationDetails();
            educationDetail.university = edtUniversity.getText().toString().trim();
            educationDetail.year = edtYear.getText().toString().trim();
            educationDetail.grade = edtGrade.getText().toString().trim();
            educationDetail.degree = edtDegree.getText().toString().trim();

            dialogClickListener.onItemClick(educationDetail);
            dialog.dismiss();
        });

        dialog.show();
    }

    public static void showAddExperienceDialog(Context context, @Nullable Experience experience,
                                               DialogClickListeners dialogClickListener) {
        Dialog dialog = new Dialog(context);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.form_experience);

        Button btnDismiss = dialog.findViewById(R.id.btnDismiss);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);

        EditText edtCompany = dialog.findViewById(R.id.edtCompany);
        EditText edtJobTitle = dialog.findViewById(R.id.edtJobTitle);
        EditText edtStartDate = dialog.findViewById(R.id.edtStartDate);
        EditText edtEndDate = dialog.findViewById(R.id.edtEndDate);
        EditText edtJobDescription = dialog.findViewById(R.id.edtJobDescription);

        if (experience != null) {
            edtCompany.setText(experience.companyName);
            edtJobTitle.setText(experience.jobTitle);
            edtStartDate.setText(experience.startDate);
            edtEndDate.setText(experience.endDate);
            edtJobDescription.setText(experience.jobDescription);
        }
        btnDismiss.setOnClickListener(v -> dialog.dismiss());
        btnAdd.setOnClickListener(v -> {
//            check validations before adding data
            Experience experienc = new Experience();
            experienc.companyName = edtCompany.getText().toString().trim();
            experienc.jobTitle = edtJobTitle.getText().toString().trim();
            experienc.startDate = edtStartDate.getText().toString().trim();
            experienc.endDate = edtEndDate.getText().toString().trim();
            experienc.jobDescription = edtJobDescription.getText().toString().trim();

            dialogClickListener.onItemClick(experienc);
            dialog.dismiss();
        });
        dialog.show();
    }

    public static void showAddSkillDialog(Context context, @Nullable SkillsModel skill,
                                          DialogClickListeners dialogClickListener) {
        List<String> coursesStringList = new ArrayList<>(), skillsStringList = new ArrayList<>();
        skillsModelArrayList = DataBaseUtil.getDatabaseInstance(context).skillsModelDao().getAllSkillsForCourse(0);

        Dialog dialog = new Dialog(context);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.form_skills);

        Button btnDismiss = dialog.findViewById(R.id.btnDismiss);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);

        Spinner spinnerSkills = dialog.findViewById(R.id.spinnerSkills);
        Spinner spinnerCourses = dialog.findViewById(R.id.spinnerCourses);
        RadioGroup formSkillsRadiogroup = dialog.findViewById(R.id.formSkillsRadiogroup);

        List<Courses> coursesList = DataBaseUtil.getDatabaseInstance(context).coursesDao().getAllCourses();
        for (Courses courses : coursesList) {
            coursesStringList.add(courses.getCourseName());
        }
        for (SkillsModel skillsModel : skillsModelArrayList) {
            skillsStringList.add(skillsModel.getSkillName());
        }
        ArrayAdapter<String> coursesAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, coursesStringList);
        spinnerCourses.setAdapter(coursesAdapter);
        ArrayAdapter<String> skillsAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, skillsStringList);
        spinnerSkills.setAdapter(skillsAdapter);

        spinnerCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                skillsModelArrayList = DataBaseUtil.getDatabaseInstance(context).skillsModelDao().getAllSkillsForCourse(coursesList.get(i).courseId);
                skillsStringList.clear();
                for (SkillsModel skillsModel : skillsModelArrayList) {
                    skillsStringList.add(skillsModel.getSkillName());
                }
                skillsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        if (skill != null) {
            for (int i = 0; i < coursesList.size(); i++) {
                if (coursesList.get(i).courseId == skill.getCourseId()) {
                    spinnerCourses.setSelection(i);
                    break;
                }
            }
            for (int i = 0; i < skillsModelArrayList.size(); i++) {
                if (skillsModelArrayList.get(i).skillId == skill.skillId) {
                    spinnerSkills.setSelection(i);
                    break;
                }
            }
            switch (skill.getLevel()) {
                case "Beginner":
                    formSkillsRadiogroup.check(R.id.radioBeginner);
                    break;
                case "Intermediate":
                    formSkillsRadiogroup.check(R.id.radioIntermediate);
                    break;
                case "Advanced":
                    formSkillsRadiogroup.check(R.id.radioAdvanced);
                    break;
                case "Expert":
                    formSkillsRadiogroup.check(R.id.radioExpert);
                    break;
            }
        }
        btnDismiss.setOnClickListener(v -> dialog.dismiss());
        btnAdd.setOnClickListener(v -> {
//            check validations before adding data
            SkillsModel skil = new SkillsModel();
            SkillsModel selectedSkillModel = skillsModelArrayList.get(spinnerSkills.getSelectedItemPosition());
//            if (skillsModelArrayList.contains(spinnerSkills.getSelectedItem())) {
//            }
            skil.setCourseId(selectedSkillModel.getCourseId());
            skil.skillId = selectedSkillModel.skillId;
            skil.setSkillName((String) spinnerSkills.getSelectedItem());
            switch (formSkillsRadiogroup.getCheckedRadioButtonId()) {
                case R.id.radioBeginner:
                    skil.setLevel("Beginner");
                    break;
                case R.id.radioIntermediate:
                    skil.setLevel("Intermediate");
                    break;
                case R.id.radioAdvanced:
                    skil.setLevel("Advanced");
                    break;
                case R.id.radioExpert:
                    skil.setLevel("Expert");
                    break;
            }
            dialogClickListener.onItemClick(skil);
            dialog.dismiss();
        });
        dialog.show();
    }

    public static void showAddProjectsDialog(Context context, @Nullable Project project,
                                             DialogClickListeners dialogClickListener) {
        Dialog dialog = new Dialog(context);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.form_project);

        Button btnDismiss = dialog.findViewById(R.id.btnDismiss);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);

        EditText edtTitle = dialog.findViewById(R.id.edtTitle);
        EditText edtProjectDescription = dialog.findViewById(R.id.edtProjectDescription);

        if (project != null) {
            edtTitle.setText(project.title);
            edtProjectDescription.setText(project.description);
        }
        btnDismiss.setOnClickListener(v -> dialog.dismiss());
        btnAdd.setOnClickListener(v -> {
//            check validations before adding data
            Project project1 = new Project();
            project1.title = edtTitle.getText().toString().trim();
            project1.description = edtProjectDescription.getText().toString().trim();

            dialogClickListener.onItemClick(project1);
            dialog.dismiss();
        });
        dialog.show();
    }

}
