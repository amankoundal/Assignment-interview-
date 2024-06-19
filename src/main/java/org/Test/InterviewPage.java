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

    @FindBy(id = "menu_title_8")
    private WebElement interview;

    @FindBy(id = "subChildTitle_8_0")
    private WebElement addCandidate;


    public void selectInterview() {
        interview.click();
    }

    public void selectAddCandidate() throws InterruptedException {
        addCandidate.click();
        Thread.sleep(1000);
    }


}
