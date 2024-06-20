package org.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionClass {
    public WebDriver driver;


    public ActionClass(WebDriver driver) {
        this.driver = driver;
    }

    public void waitElementVisible(WebElement a, int b) {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(b));
        w.until(ExpectedConditions.visibilityOf(a));

    }

    public void waitElementDisappear(WebElement b, int c) {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(c));
        w.until(ExpectedConditions.invisibilityOf(b));

    }

    public void waitElementClickable(WebElement b, int c) {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(c));
        w.until(ExpectedConditions.elementToBeClickable(b));

    }

    public void scrollPage() throws InterruptedException {
        JavascriptExecutor js=  (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)") ;
        Thread.sleep(2000);
    }




}
