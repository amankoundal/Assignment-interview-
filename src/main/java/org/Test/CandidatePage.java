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

public class CandidatePage {

    private WebDriver driver;


    public CandidatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "//span/button")
    List<WebElement> pages;

    @FindBy(id = "CandidatesList")
    private WebElement cadidate;

    @FindBy(xpath = "//tr/td[1]")
    List< WebElement> row;

    @FindBy(xpath = "(//p-paginator//div)[7]")
    WebElement totalrecord;


    @FindBy(id = "CandidatesList")
    private WebElement candidateList;

    @FindBy(xpath = "(//app-common-prime-actions//div//button)[2]")
    private WebElement schedule;


    @FindBy(id = "interviewSchedule_platform")
    private WebElement intPlatform;
    @FindBy(xpath = "(//app-basic-dropdown//select)[2]")
    private WebElement roundType;
    @FindBy(xpath = "(//app-multi-select-dropdown)[1]")
    private WebElement team;

    @FindBy(xpath = "(//app-multi-select-dropdown)[2]")
    private WebElement inter;

    @FindBy(xpath = "//p-calendar//span")
    private WebElement date;

    @FindBy(xpath="(//p-multiselect/div)[2]")
    private WebElement liveStatus;


    public void selectpages() throws InterruptedException {
      //  driver.findElement(By.id("CandidatesList")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public int countRecord() throws InterruptedException {

//        int totalCandidates = 0;  // method for getting record one by one page by clicking on the next page button(it will increase the over all test execution time)
//
//        boolean hasNextPage = true;
//        while (hasNextPage) {
//            List<WebElement> candidateElements = driver.findElements(By.xpath("//table//tbody//tr"));
//
//            // Count candidates on current page
//            int candidatesOnPage = candidateElements.size();
//            totalCandidates += candidatesOnPage;
//
//            System.out.println("Candidates on page " + driver.getCurrentUrl() + ": " + candidatesOnPage);
//
//            WebElement nextPageLink = driver.findElement(By.xpath("(//p-paginator//button)[8]"));
//            if (nextPageLink.isEnabled()) {
//                nextPageLink.click();
//                Thread.sleep(8000);
//
//            } else {
//                int numberOfPages= Integer.parseInt(driver.findElement(By.xpath("(//p-paginator//button)[6]")).getText());
//                System.out.println("previous page "+driver.findElement(By.xpath("(//p-paginator//button)[6]")).getText());
//                hasNextPage = false;
//            }
//        }
//            int totalRecord= totalCandidates;
//
//        System.out.println("Total number of candidates: " + totalCandidates);
        int totalCandidates = 0; // method for getting record one and last page by clicking on the last page button
        boolean hasNextPage = true;
        int candidatesOnFirstPage = 0;
        int totalNumberOfPages = 0;
        int candidatesOnLastPage = 0;

// Get candidates on the first page
        List<WebElement> candidateElements = driver.findElements(By.xpath("//table//tbody//tr"));
        candidatesOnFirstPage = candidateElements.size();

        System.out.println("Candidates on first page " + driver.getCurrentUrl() + ": " + candidatesOnFirstPage);

        WebElement lastPageLink = driver.findElement(By.xpath("(//p-paginator//button)[9]"));
        if (lastPageLink.isEnabled()) {
            lastPageLink.click();
            Thread.sleep(8000);

            candidateElements = driver.findElements(By.xpath("//table//tbody//tr"));
            candidatesOnLastPage = candidateElements.size();
            System.out.println("Candidates on last page " + driver.getCurrentUrl() + ": " + candidatesOnLastPage);
            WebElement totalPagesElement = driver.findElement(By.xpath("(//p-paginator//button)[6]"));
            totalNumberOfPages = Integer.parseInt(totalPagesElement.getText());
            System.out.println("Second last page NO: " + totalNumberOfPages);
            totalCandidates = (candidatesOnFirstPage * (totalNumberOfPages )) + candidatesOnLastPage;
        } else {
            // Only one page
            totalCandidates = candidatesOnFirstPage;
        }
        int totalRecords= totalCandidates;
        System.out.println("Total number of candidates: " + totalCandidates);
        return totalRecords;

    }

    public int getTotalReorcd(){
        String record= totalrecord.getText();// Total Records : 395
        String[] b= (record.split(":"));
        int totalcount= Integer.parseInt(b[1].trim());
        System.out.println(totalcount);
        return totalcount;

    }

    public void selectCandidateList() throws InterruptedException {
        cadidate.click();
        Thread.sleep(2000);
    }

    public void selectScheduleInterview() throws InterruptedException {
        Thread.sleep(1000);
        schedule.click();
    }

    public void selectInterviewPlatForm(String text) throws InterruptedException {
        Select dropdown = new Select(intPlatform);
        Thread.sleep(1000);
        dropdown.selectByVisibleText(text);
    }

    public void selectRoundType(String text) throws InterruptedException {
        Select dropdown = new Select(roundType);
        Thread.sleep(1000);
        dropdown.selectByVisibleText(text);
    }

    public void selectTeam(String text) throws InterruptedException {
        team.click();
        driver.findElement(By.xpath("//div[normalize-space()='"+text+"']")).click();
        Thread.sleep(1000);
    }

    public void selectInterviewer(){
        inter.click();
    }

    public void selectCalender(String mnth, String yer) throws InterruptedException {
        date.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("p-datepicker-group-container")));
        String monthYear= driver.findElement(By.className("p-datepicker-title")).getText();
        System.out.println(monthYear);
        String month = monthYear.split(" ")[0].trim();
        String year = monthYear.split(" ")[1].trim();

        while(!(month.equals(mnth)) && year.equals(yer)){
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@class='p-ripple p-element p-datepicker-prev p-link ng-tns-c2639595829-5 ng-star-inserted']")).click();
            monthYear= driver.findElement(By.className("p-datepicker-title")).getText();
            System.out.println(monthYear);
            month = monthYear.split(" ")[0].trim();
            year = monthYear.split(" ")[0].trim();
        }
        driver.findElement(By.xpath("(//span[text()='21'])[1]")).click();
    }

    public void selectSubmitButton(){
        driver.findElement(By.id("interviewSchedule_btn_submit_3655")).click();
    }

    public void changeLiveStatus(String text) throws InterruptedException {
        Select dropdown = new Select(liveStatus);
        Thread.sleep(1000);
        dropdown.selectByVisibleText(text);
        Thread.sleep(1000);
    }

    public void acceptAlert(){
        driver.findElement(By.xpath("(//div[@class='swal2-actions']//button)[1]")).click();
    }
}
