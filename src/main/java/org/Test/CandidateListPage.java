package org.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class CandidateListPage extends ActionClass {

    public CandidateListPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "//span/button")
    List <WebElement> pages;

    @FindBy(id = "candidateList_div_h3")
    private WebElement cadidate;

    @FindBy(xpath = "//tr/td[1]")
    List< WebElement> row;



    public void selectpages() throws InterruptedException {
        driver.findElement(By.id("CandidatesList")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void countRecord() throws InterruptedException {

        int totalCandidates = 0;

        // Loop through pages (example assumes pagination with page numbers)
        boolean hasNextPage = true;
        while (hasNextPage) {
            // Find all candidate elements on the current page
            List<WebElement> candidateElements = driver.findElements(By.xpath("//table//tbody//tr"));

            // Count candidates on current page
            int candidatesOnPage = candidateElements.size();
            totalCandidates += candidatesOnPage;

            // Output candidate information (for demonstration)
            System.out.println("Candidates on page " + driver.getCurrentUrl() + ": " + candidatesOnPage);

            WebElement nextPageLink = driver.findElement(By.xpath("(//p-paginator//button)[9]"));
            if (nextPageLink.isEnabled()) {
                nextPageLink.click();
                Thread.sleep(8000);

            } else {
                int numberOfPages= Integer.parseInt(driver.findElement(By.xpath("(//p-paginator//button)[6]")).getText());
                System.out.println("previous page "+driver.findElement(By.xpath("(//p-paginator//button)[6]")).getText());
                hasNextPage = false; // Exit loop if no more pages
            }
        }
            int totalRecord= totalCandidates;
        // Output total number of candidates
        System.out.println("Total number of candidates: " + totalCandidates);
    }



}
