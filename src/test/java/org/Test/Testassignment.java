package org.Test;

import GlobalClass.Baseclass;
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
