package org.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    @FindBy(id = "upload-resume")
    private WebElement fileUpload;

    @FindBy(xpath = "//span[@class='mdc-list-item__primary-text']")
    private WebElement searchResult;

    @FindBy(id = "candidateDetail-totalWorkExperience_years")
    private WebElement expYear;

    @FindBy(id = "candidateDetail-totalWorkExperience_months")
    private WebElement expMonth;

    @FindBy(id = "candidateDetail-relavantWorkExperience_years")
    private WebElement relevantExpYear;

    @FindBy(id = "candidateDetail-relavantWorkExperience_months")
    private WebElement relevantExpMonth;

    @FindBy(id = "Last Appraisal Date")
    private WebElement lastAppraisal;

    @FindBy(xpath = "//button[normalize-space()='2023']")
    private WebElement selectYear;

    public void enterCandidateName(String cadName) {
        waitElementVisible(name, 10);
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

    public void selectPlaform(String text) {
        Select dropdown = new Select(platform);
        dropdown.selectByVisibleText(text);
    }

    public void enterAppliedForTeam(String text2) throws InterruptedException {
        appliedFor.sendKeys(text2);
        waitElementVisible(searchResult, 8);
        searchResult.click();
    }

    public void enterDesignation(String text3) throws InterruptedException {
        designation.sendKeys(text3);
        waitElementVisible(searchResult, 8);
        searchResult.click();
    }

    public void enterSkillSet(String text4) {
        skillSet.sendKeys(text4);
    }

    public void setUploadCv() throws InterruptedException {

        String filePath = System.getProperty("user.dir") + "/src/main/java/Resource/functionalsample.pdf";
        fileUpload.sendKeys(filePath);
    }

    public void addExperienceYear(String text) throws InterruptedException {
        waitElementVisible(expYear, 5);
        Select dropdown = new Select(expYear);
        dropdown.selectByVisibleText(text);
    }

    public void addExperienceMonth(String text) throws InterruptedException {
        Select dropdown = new Select(expMonth);
        Thread.sleep(1000);
        dropdown.selectByVisibleText(text);
    }

    public void addRelevantExpYear(String text) throws InterruptedException {
        Select dropdown = new Select(relevantExpYear);
        Thread.sleep(1000);
        dropdown.selectByVisibleText(text);
    }

    public void addRelevantExpMonth(String text) throws InterruptedException {
        Select dropdown = new Select(relevantExpMonth);
        Thread.sleep(1000);
        dropdown.selectByVisibleText(text);
    }

    public void setLastAppraisal() throws InterruptedException {
        lastAppraisal.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("p-datepicker-group-container")));
       String monthYear= driver.findElement(By.className("p-datepicker-title")).getText();
        System.out.println(monthYear);
        String month = monthYear.split(" ")[0].trim();
        String year = monthYear.split(" ")[1].trim();

        while(!(month.equals("June")) && year.equals("2023")){
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@class='p-ripple p-element p-datepicker-prev p-link ng-tns-c2639595829-5 ng-star-inserted']")).click();
             monthYear= driver.findElement(By.className("p-datepicker-title")).getText();
            System.out.println(monthYear);
            month = monthYear.split(" ")[0].trim();
            year = monthYear.split(" ")[0].trim();
        }
        driver.findElement(By.xpath("(//span[text()='6'])[1]")).click();
    }


}