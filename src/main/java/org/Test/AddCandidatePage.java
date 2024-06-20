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

    @FindBy(id = "timedragon_id_12731")
    private WebElement appliedFor;

    @FindBy(xpath = "(//input[@id='timedragon_id_12731'])[2]")
    private WebElement designation;

    @FindBy(xpath = "(//input[@id='timedragon_id_12731'])[3]")
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

    @FindBy(id = "candidateDetail-workingDays")
    private WebElement wrkingday;

    @FindBy(id="Last Working Date")
    private WebElement lastworking;

    @FindBy(id="candidateDetail-currentSalary")
    private WebElement currentSalary;

    @FindBy(id="candidateDetail-expectedtSalary")
    private WebElement expectedSalary;

    @FindBy(id="candidateDetail-noticePeriod")
    private WebElement notice;

    @FindBy(id="Expected Joining Date")
    private WebElement exptDate;

    @FindBy(id="candidate_detail_submit_btn_3241")
    private WebElement send;


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

    public void selectPlaform(String text) throws InterruptedException {
        Select dropdown = new Select(platform);
        dropdown.selectByVisibleText(text);
        Thread.sleep(1000);
    }

    public void enterAppliedForTeam(String text2) throws InterruptedException {
        waitElementClickable(appliedFor,5);
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
        Thread.sleep(2000);
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

    public void setLastAppraisal(String mnth, String yer) throws InterruptedException {
        lastAppraisal.click();
        selectDateInCalender(mnth,yer);
    }

    public void selectDateInCalender(String mnth, String yer) throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("p-datepicker-group-container")));
        String monthYear= driver.findElement(By.className("p-datepicker-title")).getText();
        System.out.println(monthYear);
        String month = monthYear.split(" ")[0].trim();
        String year = monthYear.split(" ")[1].trim();

        while(!(month.equals(mnth)) && year.equals(yer)){
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/button[1]")).click();
            monthYear= driver.findElement(By.className("p-datepicker-title")).getText();
            System.out.println(monthYear);
            month = monthYear.split(" ")[0].trim();
            year = monthYear.split(" ")[0].trim();
        }
        driver.findElement(By.xpath("(//span[text()='6'])[1]")).click();
    }
    public void workingDaysInLastCompany(String days) throws InterruptedException {
        Select dropdown = new Select(wrkingday);
        Thread.sleep(1000);
        dropdown.selectByVisibleText(days);
    }

    public void setLastworkingDate(String mnth, String yer) throws InterruptedException {
        lastworking.click();
        selectDateInCalender(mnth, yer);
    }

    public void setCurrentSalary(String text){
        currentSalary.sendKeys(text);
    }

    public void setExpectedSalary(String text){
        expectedSalary.sendKeys(text);
    }

    public void setNoticePeriod(String text) throws InterruptedException {
        Select dropdown = new Select(notice);
        Thread.sleep(1000);
        dropdown.selectByVisibleText(text);
    }

    public void setExpectedJoiningDate(String mnth, String yer) throws InterruptedException {
        exptDate.click();
        selectDateInCalender(mnth, yer);
    }

    public void selectSendForScreening(){
        send.click();


    }
}