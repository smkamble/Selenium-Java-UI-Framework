package com.stackoverflow.tests;

import com.stackoverflow.TestBase;
import com.stackoverflow.utilities.ApplicationConstants;

import org.testng.annotations.*;

import static org.testng.Assert.*;

public class StackOverflowTests extends TestBase {

    @Test()
    public void getTheTagNameWhichIsHavingMaxQuestionsCount() {
        extentLogger = report.createTest("Tag Name Which Is Having Max Questions Count Test");
        extentLogger.info("Verifying home page title");
        assertEquals(driver.getTitle(), ApplicationConstants.HOME_PAGE_TITLE);
        extentLogger.info("Click on Browse Question");
        pages.homePage().clickBrowseQuestion();
        extentLogger.info("Click on Tag");
        pages.homePage().clickTags();
        extentLogger.info("Click on Name");
        pages.homePage().clickName();
        System.out.println("Tag with highest value: " + pages.homePage().getMaxQuestionCount());
        extentLogger.info("Tag with highest value: " + pages.homePage().getMaxQuestionCount());
        extentLogger.pass("Completed: Tag Name Which Is Having Max Questions Count Test");
    }

}
