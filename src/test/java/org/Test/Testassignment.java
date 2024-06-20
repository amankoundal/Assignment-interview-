package org.Test;

import GlobalClass.Baseclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Testassignment extends Baseclass {

    @Test(dataProvider = "getData")
    public void logIn(HashMap<String, String> input) throws InterruptedException {
        String actualText = logIn.getWelcomePageText();
        String expectedText = "Welcome!";
        Assert.assertEquals(actualText, expectedText);
        logIn.enterId(input.get("Priti"));
        logIn.enterPassword(input.get("password"));
        logIn.clickOnSignIn();
        String actuallAcc = logIn.CheckLogIntoEmployAcc();
        Assert.assertEquals(actuallAcc, "Personal Information");

    }

    @Test(dataProvider = "getData", dependsOnMethods = "logIn")
    public void interviewOption(HashMap<String, String> input) throws InterruptedException {
        interview.selectInterview();
        interview.selectAddCandidate();
        addCandidatePage.enterCandidateName(input.get("candidateName"));
        addCandidatePage.enterCandidateEmail(input.get("candidateEmail"));
        addCandidatePage.enterCandidatePhoneNO(input.get("candidatePhoneNo"));
        addCandidatePage.selectVerify();
        addCandidatePage.selectPlaform(input.get("platform"));
        addCandidatePage.enterAppliedForTeam(input.get("appliedForTeam"));
        addCandidatePage.enterDesignation(input.get("designation"));
        addCandidatePage.enterSkillSet(input.get("skillset"));
        addCandidatePage.setUploadCv();
        addCandidatePage.addExperienceYear(input.get("addExperienceYear"));
        addCandidatePage.addExperienceMonth(input.get("addExperienceMonth"));
        addCandidatePage.addRelevantExpYear(input.get("addRelevantExpYear"));
        addCandidatePage.addRelevantExpMonth(input.get("addRelevantExpMonth"));
        addCandidatePage.setLastAppraisal(input.get("month"),input.get("year"));
        addCandidatePage.workingDaysInLastCompany(input.get("lastWorkingDays"));
        addCandidatePage.setLastworkingDate(input.get("month"),input.get("year"));
        addCandidatePage.setCurrentSalary(input.get("currentSalary"));
        addCandidatePage.setExpectedSalary(input.get("expectedSalary"));
        addCandidatePage.setNoticePeriod(input.get("noticePeriod"));
//       // addCandidatePage.setExpectedJoiningDate(input.get("month"),input.get("year"));
        addCandidatePage.selectSendForScreening();
    }


    @Test(dataProvider = "getData", dependsOnMethods = "interviewOption")
    public void candidateRecord(HashMap<String, String> input) throws InterruptedException {
        candidatePage.selectpages();
       int actualRecord= candidatePage.countRecord();
        int expectedRecord= candidatePage.getTotalReorcd();
        Assert.assertEquals(actualRecord,expectedRecord);

    }


    @Test(dataProvider = "getData", dependsOnMethods = "candidateRecord")
    public void screeningTest(HashMap<String, String> input) throws InterruptedException {
        screeningPage.selectScreeningOption();
        screeningPage.searchCandidate(input.get("candidateName"));
        screeningPage.allowScreeningRequest();
    }

    @Test(dataProvider = "getData", dependsOnMethods = "screeningTest")
    public void scheduleTest(HashMap<String, String> input) throws InterruptedException {
       // interview.selectInterview();
        candidatePage.selectCandidateList();
        screeningPage.searchCandidate(input.get("candidateName"));
        candidatePage.selectScheduleInterview();
        candidatePage.selectInterviewPlatForm(input.get("interviewPlatform"));
        candidatePage.selectRoundType(input.get("roundType"));
        candidatePage.selectTeam(input.get("selectTeam"));
        candidatePage.selectInterviewer();
        candidatePage.selectCalender(input.get("month"),input.get("year"));
        candidatePage.selectSubmitButton();
        //candidatePage.changeLiveStatus(input.get("liveStatus"));
        //candidatePage.acceptAlert();



    }


    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataTOMap(
                System.getProperty("user.dir") + "/src/main/java/Resource/Assigment.json");
        return new Object[][]{{data.get(0)}
                // , { data.get(1) }
        };
    }

}
