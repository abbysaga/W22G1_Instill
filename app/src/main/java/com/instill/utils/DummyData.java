package com.instill.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.pdf.PdfDocument;

import com.instill.R;
import com.instill.database.dbmodels.Courses;
import com.instill.database.dbmodels.SkillsModel;
import com.instill.database.dbmodels.SuggestionsModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class DummyData {

    public static ArrayList<Courses> getDummyCourses() {
        ArrayList<Courses> coursesList = new ArrayList<>();

        Courses courses = new Courses();
        courses.setCourseName("CSIS - Computing Systems and Information Systems");
        coursesList.add(courses);

        courses = new Courses();
        courses.setCourseName("Economics & Finance");
        coursesList.add(courses);

        courses = new Courses();
        courses.setCourseName("Marketing & Office Administration");
        coursesList.add(courses);

        courses = new Courses();
        courses.setCourseName("Literature, Language & Arts");
        coursesList.add(courses);

        courses = new Courses();
        courses.setCourseName("Science & Technology");
        coursesList.add(courses);

        return coursesList;
    }

    public static ArrayList<SkillsModel> getDummySkills() {
        ArrayList<SkillsModel> skillsModelArrayList = new ArrayList<>();

        SkillsModel skillsModel = new SkillsModel();
        skillsModel.setCourseId(1);
        skillsModel.setSkillName("Java");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(1);
        skillsModel.setSkillName("JavaScript");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(1);
        skillsModel.setSkillName("Python");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(1);
        skillsModel.setSkillName("Machine Learning");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(1);
        skillsModel.setSkillName("React");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(1);
        skillsModel.setSkillName("NodeJS");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(1);
        skillsModel.setSkillName("Angular");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(1);
        skillsModel.setSkillName("Database");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(1);
        skillsModel.setSkillName("AWS");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(1);
        skillsModel.setSkillName("DevOps");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(1);
        skillsModel.setSkillName("Android");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(1);
        skillsModel.setSkillName("iOS");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(1);
        skillsModel.setSkillName("Windows");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(2);
        skillsModel.setSkillName("Economics Handling");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(2);
        skillsModel.setSkillName("Econ 2201");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(2);
        skillsModel.setSkillName("Analysis of Economics");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(2);
        skillsModel.setSkillName("Finance");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(2);
        skillsModel.setSkillName("Stock");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(2);
        skillsModel.setSkillName("Trading");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(2);
        skillsModel.setSkillName("Real Estate");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(3);
        skillsModel.setSkillName("Marketing");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(3);
        skillsModel.setSkillName("Social Media");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(3);
        skillsModel.setSkillName("Ads");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(3);
        skillsModel.setSkillName("Excel");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(4);
        skillsModel.setSkillName("English");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(4);
        skillsModel.setSkillName("French");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(4);
        skillsModel.setSkillName("Music");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(4);
        skillsModel.setSkillName("Drawing");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(4);
        skillsModel.setSkillName("Content Writing");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(5);
        skillsModel.setSkillName("Astronomy");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(5);
        skillsModel.setSkillName("Biology");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(5);
        skillsModel.setSkillName("Chemistry");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(5);
        skillsModel.setSkillName("Physics");
        skillsModelArrayList.add(skillsModel);

        skillsModel = new SkillsModel();
        skillsModel.setCourseId(5);
        skillsModel.setSkillName("Robotics");
        skillsModelArrayList.add(skillsModel);

        return skillsModelArrayList;
    }

    public static ArrayList<SuggestionsModel> getDummySuggestions() {
        ArrayList<SuggestionsModel> suggestionsModelArrayList = new ArrayList<>();
        ArrayList<String> skillsLinks;

        SuggestionsModel suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(1);
        skillsLinks.add("https://www.w3schools.com/java/");
        skillsLinks.add("https://www.tutorialspoint.com/java/index.htm");
        skillsLinks.add("https://www.javatpoint.com/java-tutorial");
        skillsLinks.add("https://www.guru99.com/java-tutorial.html");
        skillsLinks.add("https://beginnersbook.com/java-tutorial-for-beginners-with-examples/");
        skillsLinks.add("https://www.codecademy.com/learn/learn-java");
        skillsLinks.add("https://www.udemy.com/course/java-tutorial/");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(2);
        skillsLinks.add("https://www.pluralsight.com/courses/quick-start-javascript-1-1870?aid=701j0000001heIqAAI&promo=&utm_source=non_branded&utm_medium=digital_paid_search_google&utm_campaign=CA_Dynamic&utm_content=&cq_cmp=179446878&gclid=Cj0KCQjwl7qSBhD-ARIsACvV1X1EyCNWJwx3opIC9wwxqTTrjFJ3Nthe0fF7uYEsBOdCArggYgocELsaArp0EALw_wcB");
        skillsLinks.add("https://www.w3schools.com/js/");
        skillsLinks.add("https://javascript.info/");
        skillsLinks.add("https://www.codecademy.com/learn/introduction-to-javascript");
        skillsLinks.add("https://www.guru99.com/interactive-javascript-tutorials.html");
        skillsLinks.add("https://www.javascripttutorial.net/");
        skillsLinks.add("https://www.tutorialspoint.com/javascript/index.htm");
        skillsLinks.add("https://www.javatpoint.com/javascript-tutorial");
        skillsLinks.add("https://www.tutorialrepublic.com/javascript-tutorial/");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(3);
        skillsLinks.add("https://www.w3schools.com/python/default.asp");
        skillsLinks.add("https://www.tutorialspoint.com/python/index.htm");
        skillsLinks.add("https://www.programiz.com/python-programming");
        skillsLinks.add("https://www.codecademy.com/catalog/language/python");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(4);
        skillsLinks.add("https://www.ibm.com/cloud/learn/machine-learning");
        skillsLinks.add("https://www.coursera.org/learn/machine-learning");
        skillsLinks.add("https://developers.google.com/machine-learning/crash-course");
        skillsLinks.add("https://www.w3schools.com/python/python_ml_getting_started.asp");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(5);
        skillsLinks.add("https://reactjs.org/tutorial/tutorial.html");
        skillsLinks.add("https://www.w3schools.com/REACT/DEFAULT.ASP");
        skillsLinks.add("https://ibaslogic.com/react-tutorial-for-beginners/");
        skillsLinks.add("https://www.javatpoint.com/reactjs-tutorial");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(6);
        skillsLinks.add("https://www.w3schools.com/nodejs/");
        skillsLinks.add("https://nodejs.dev/learn");
        skillsLinks.add("https://www.tutorialspoint.com/nodejs/index.htm");
        skillsLinks.add("https://www.codecademy.com/learn/learn-node-js");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(7);
        skillsLinks.add("https://www.w3schools.com/angular/default.asp");
        skillsLinks.add("https://angular.io/tutorial");
        skillsLinks.add("https://www.tutorialspoint.com/angular7/index.htm");
        skillsLinks.add("https://www.tutorialsteacher.com/angular");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);


        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(8);
        skillsLinks.add("https://www.w3schools.com/sql/");
        skillsLinks.add("https://www.tutorialspoint.com/dbms/index.htm");
        skillsLinks.add("https://www.quackit.com/database/tutorial/");
        skillsLinks.add("https://www.quackit.com/database/tutorial/");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(9);
        skillsLinks.add("https://www.tutorialspoint.com/amazon_web_services/index.htm");
        skillsLinks.add("https://www.w3schools.com/aws/index.php");
        skillsLinks.add("https://www.javatpoint.com/aws-tutorial");
        skillsLinks.add("https://www.guru99.com/aws-tutorial.html");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(10);
        skillsLinks.add("https://www.guru99.com/devops-tutorial.html");
        skillsLinks.add("https://www.javatpoint.com/devops");
        skillsLinks.add("https://www.tutorialspoint.com/devops_tutorials.htm");
        skillsLinks.add("https://www.edureka.co/blog/devops-tutorial");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(11);
        skillsLinks.add("https://developer.android.com/training/basics/firstapp");
        skillsLinks.add("https://www.tutorialspoint.com/android/index.htm");
        skillsLinks.add("https://www.guru99.com/android-tutorial.html");
        skillsLinks.add("https://www.geeksforgeeks.org/android-tutorial/");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(12);
        skillsLinks.add("https://www.javatpoint.com/ios-development-using-swift");
        skillsLinks.add("https://developer.apple.com/tutorials/app-dev-training");
        skillsLinks.add("https://www.tutlane.com/tutorial/ios");
        skillsLinks.add("https://www.udemy.com/course/the-art-of-real-ios-programming/");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(13);
        skillsLinks.add("https://www.tutorialspoint.com/windows10/index.htm");
        skillsLinks.add("https://www.javatpoint.com/what-is-windows");
        skillsLinks.add("https://www.top-windows-tutorials.com/");
        skillsLinks.add("https://www.microsoft.com/en-us/download/how-to-tutorials.aspx");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(14);
        skillsLinks.add("https://www.tutorialspoint.com/managerial_economics/index.htm");
        skillsLinks.add("https://www.geektonight.com/business-economics/");
        skillsLinks.add("https://www.investopedia.com/terms/e/economics.asp");
        skillsLinks.add("https://www.managementstudyguide.com/managerial-economics.htm");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(15);
        skillsLinks.add("https://carleton.ca/economics/wp-content/uploads/econ-2201g-webb-w16.pdf");
        skillsLinks.add("https://www.wizeprep.com/courses/Econ2201-california-state-university-san-bernardino-af63f0cd-df84-4701-80e1-bc95b6ec824d/on-demand");
        skillsLinks.add("https://www.cscc.edu/academics/departments/social-science/economics.shtml");
        skillsLinks.add("https://www.coursehero.com/file/62409412/econ-2201c-quadir-f14pdf/");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(16);
        skillsLinks.add("https://www.linkedin.com/learning/excel-economic-analysis-and-data-analytics/basics-of-economic-analysis");
        skillsLinks.add("https://econtutorials.com/");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(17);
        skillsLinks.add("https://edu.gcfglobal.org/en/topics/personal-finance/");
        skillsLinks.add("https://www.tutorialspoint.com/financial_accounting/index.htm");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(18);
        skillsLinks.add("https://www.investopedia.com/articles/basics/06/invest1000.asp");
        skillsLinks.add("https://www.udemy.com/course/the-beginners-guide-to-the-stock-market/");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(19);
        skillsLinks.add("https://www.investopedia.com/articles/trading/05/011705.asp");
        skillsLinks.add("https://www.coursera.org/learn/trading-basics");
        skillsLinks.add("https://www.sec.gov/files/trading101basics.pdf");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(20);
        skillsLinks.add("https://www.realestatetutorialsonline.com/");
        skillsLinks.add("https://placester.com/real-estate-marketing-academy/beginners-guide-to-being-a-real-estate-agent");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(21);
        skillsLinks.add("https://www.tutorialspoint.com/digital_marketing/index.htm");
        skillsLinks.add("https://www.guru99.com/free-digital-marketing-tutorial.html");
        skillsLinks.add("https://www.javatpoint.com/marketing-tutorial");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(22);
        skillsLinks.add("https://www.simplilearn.com/tutorials/social-media-marketing-tutorial/how-to-do-social-media-marketing");
        skillsLinks.add("https://blog.hubspot.com/marketing/social-media-marketing-resources");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(23);
        skillsLinks.add("https://www.spyfu.com/blog/google-ads-tutorial/");
        skillsLinks.add("https://surfsideppc.com/google-ads/");
        skillsLinks.add("https://www.simplilearn.com/tutorials/social-media-marketing-tutorial/how-to-advertise-on-youtube");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(24);
        skillsLinks.add("https://www.w3schools.com/EXCEL/index.php");
        skillsLinks.add("https://www.guru99.com/excel-tutorials.html");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(25);
        skillsLinks.add("https://www.talkenglish.com/");
        skillsLinks.add("https://learnenglish.britishcouncil.org/");
        skillsLinks.add("https://blog.udemy.com/spoken-english-tutorial/");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(26);
        skillsLinks.add("http://www.frenchtutorial.com/");
        skillsLinks.add("https://www.duolingo.com/course/fr/en/Learn-French");
        skillsLinks.add("https://www.elearningfrench.com/");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(27);
        skillsLinks.add("https://learningmusic.ableton.com/");
        skillsLinks.add("https://www.groove3.com/");
        skillsLinks.add("https://learningmusic.ableton.com/");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(28);
        skillsLinks.add("https://www.creativebloq.com/features/how-to-draw-animals-people-landscapes");
        skillsLinks.add("https://easydrawingtutorials.com/");
        skillsLinks.add("https://rapidfireart.com/free-drawing-tutorials/");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(29);
        skillsLinks.add("https://www.henryharvin.com/blog/content-writing-tutorial-for-beginners/");
        skillsLinks.add("https://www.contentpowered.com/blog/content-writing-tips-beginners/");
        skillsLinks.add("https://iimskills.com/content-writing-tutorial-for-beginners/");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(30);
        skillsLinks.add("https://skyandtelescope.org/astronomy-resources/stargazing-basics/how-to-start-right-in-astronomy/");
        skillsLinks.add("https://www.planetary.org/night-sky/astronomy-for-beginners");
        skillsLinks.add("https://www.skymaponline.net/tutorial/00_toc.html");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(31);
        skillsLinks.add("https://bio.libretexts.org/Learning_Objects/Worksheets/Biology_Tutorials");
        skillsLinks.add("https://www.tutorialspoint.com/biology_part1/biology_quick_guide.htm");
        skillsLinks.add("https://learn-biology.com/");
        skillsLinks.add("https://biologydictionary.net/ap-biology/");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(32);
        skillsLinks.add("https://www.chem1.com/chemed/tutorial.shtml");
        skillsLinks.add("https://www.learnchem.net/tutorials/");
        skillsLinks.add("https://www.grandinetti.org/general-chemistry-tutorial");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(33);
        skillsLinks.add("https://www.physicsclassroom.com/class");
        skillsLinks.add("https://www.physics.uoguelph.ca/physics-tutorials");
        skillsLinks.add("https://durhamtech.libguides.com/physics/tutorials");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        suggestionsModel = new SuggestionsModel();
        skillsLinks = new ArrayList<>();
        suggestionsModel.setSkillId(34);
        skillsLinks.add("https://www.javatpoint.com/robotics-tutorial");
        skillsLinks.add("https://learn.sparkfun.com/tutorials/tags/robotics?page=all");
        skillsLinks.add("http://www.robotictutorials.com/");
        skillsLinks.add("https://toptechboy.com/robotic-tutorial-for-beginners/");
        suggestionsModel.setSkillLinks(skillsLinks);
        suggestionsModelArrayList.add(suggestionsModel);

        return suggestionsModelArrayList;
    }

    public void createResumePDF(Context context) {
//        If not working, we can try this way from html
//        https://github.com/IbrahimYousre/Resume-Builder
        String name = "FistPDFResume", username = "trfygikplo;", email = "sgfvauv,ghj@gntd.com", content = "srgytea8bli,gsuobyekmchudmgbunw,uekb",
                address = "bffgknxhf g vagnikZW,\n bsufafgakbxfj";

        Rect bounds = new Rect();
        int pageWidth = 300;
        int pageheight = 470;
        int pathHeight = 2;

        PdfDocument myPdfDocument = new PdfDocument();
        Paint paint = new Paint();
        Paint paint2 = new Paint();
        Path path = new Path();
        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(pageWidth, pageheight, 1).create();
        PdfDocument.Page documentPage = myPdfDocument.startPage(myPageInfo);
        Canvas canvas = documentPage.getCanvas();
        int y = 25; // x = 10,
        //int x = (canvas.getWidth() / 2);
        int x = 10;

        paint.getTextBounds(username, 0, name.length(), bounds);
        x = (canvas.getWidth() / 2) - (bounds.width() / 2);
        canvas.drawText(username, x, y, paint);

        paint.getTextBounds(email, 0, email.length(), bounds);
        x = (canvas.getWidth() / 2) - (bounds.width() / 2);
        y += paint.descent() - paint.ascent();
        canvas.drawText(email, x, y, paint);

        y += paint.descent() - paint.ascent();
        canvas.drawText("", x, y, paint);

        //horizontal line
        path.lineTo(pageWidth, pathHeight);
        paint2.setColor(Color.GRAY);
        paint2.setStyle(Paint.Style.STROKE);
        path.moveTo(x, y);

        canvas.drawLine(0, y, pageWidth, y, paint2);

        //blank space
        y += paint.descent() - paint.ascent();
        canvas.drawText("", x, y, paint);

        y += paint.descent() - paint.ascent();
        x = 10;
        canvas.drawText(content, x, y, paint);

        y += paint.descent() - paint.ascent();
        x = 10;
        canvas.drawText(address, x, y, paint);

        //blank space
        y += paint.descent() - paint.ascent();
        canvas.drawText("", x, y, paint);

        //horizontal line
        path.lineTo(pageWidth, pathHeight);
        paint2.setColor(Color.GRAY);
        paint2.setStyle(Paint.Style.STROKE);
        path.moveTo(x, y);
        canvas.drawLine(0, y, pageWidth, y, paint2);

        //blank space
        y += paint.descent() - paint.ascent();
        canvas.drawText("", x, y, paint);

        Resources res = context.getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.ic_user);
        Bitmap b = (Bitmap.createScaledBitmap(bitmap, 100, 50, false));
        canvas.drawBitmap(b, x, y, paint);
        y += 25;
        canvas.drawText(context.getString(R.string.app_name), 120, y, paint);

        myPdfDocument.finishPage(documentPage);

        File file = new File(context.getExternalFilesDir(null).getAbsolutePath() + name + ".pdf");
        try {
            myPdfDocument.writeTo(new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        myPdfDocument.close();
//        viewPdfFile();
    }

}
