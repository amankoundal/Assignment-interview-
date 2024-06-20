package org.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScreeningPage {
    private WebDriver driver;


    public ScreeningPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="ScreeningRequest")
    private WebElement screen;

    @FindBy(xpath = "//span//input")
    private WebElement search;


    @FindBy(xpath = "(//app-common-prime-actions//div//button)[3]")
    private WebElement allow;

    public void selectScreeningOption() throws InterruptedException {
        screen.click();
        Thread.sleep(3000);
    }


    public void searchCandidate(String name) throws InterruptedException {
        Thread.sleep(6000);
        search.sendKeys(name);
        Thread.sleep(3000);
    }

    public void allowScreeningRequest(){
        allow.click();
    }

}
