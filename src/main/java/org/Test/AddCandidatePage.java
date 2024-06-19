package org.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCandidatePage extends ActionClass {
    public AddCandidatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "candidateDetail-name")
    private WebElement name;

    @FindBy(id = "candidateDetail-email")
    private WebElement email;

    @FindBy(id = "candidateDetail-contactNumber")
    private WebElement phoneNo;

    @FindBy(id = "candidate_detail_btn__verify_3083")
    private WebElement verify;

    @FindBy(id = "candidateDetail-contactedPlatform")
    private WebElement platform;

    @FindBy(id = "candidateDetail-appliedForTeam")
    private WebElement appliedFor;

    @FindBy(id = "candidateDetail-designation")
    private WebElement designation;

    @FindBy(id = "candidateDetail-skillSet")
    private WebElement skillSet;

    @FindBy(xpath = "//span[contains(text(),'Drag and drop or')]")
    private WebElement uploadCv;

    @FindBy(xpath = "//span[@class='mdc-list-item__primary-text']")
    private WebElement searchResult;

    public void enterCandidateName(String cadName) {
        name.sendKeys(cadName);
    }

    public void enterCandidateEmail(String cadEmail) {
        email.sendKeys(cadEmail);
    }

    public void enterCandidatePhoneNO(String cadPhoneNo) {
        phoneNo.sendKeys(cadPhoneNo);
    }

    public void selectVerify() throws InterruptedException {
        verify.click();
        Thread.sleep(2000);
        scrollPage();
    }

    public void selectPlaform(String text){
        Select dropdown = new Select(platform);
        dropdown.selectByVisibleText(text);
    }

    public void enterAppliedForTeam(String text2) throws InterruptedException {
        appliedFor.sendKeys(text2);
        waitElementVisible(searchResult,7);
        searchResult.click();
    }

    public void enterDesignation(String text3) throws InterruptedException {
        designation.sendKeys(text3);
        waitElementVisible(searchResult,7);
       searchResult.click();
    }

    public void enterSkillSet(String text4){
        skillSet.sendKeys(text4);
    }

    public void setUploadCv() throws InterruptedException {
        Thread.sleep(1000);
        String filePath="/Users/amankoundal/Downloads/functionalsample.pdf";
        uploadCv.sendKeys(filePath);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
