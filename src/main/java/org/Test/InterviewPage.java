package org.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InterviewPage extends ActionClass {

    public WebDriver driver;

    public InterviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Interview")
    private WebElement interview;

    @FindBy(id = "AddCandidate")
    private WebElement addCandidate;


    public void selectInterview() throws InterruptedException {
        Thread.sleep(1000);
        interview.click();
    }

    public void selectAddCandidate() throws InterruptedException {
        addCandidate.click();
        Thread.sleep(1000);
    }


}
