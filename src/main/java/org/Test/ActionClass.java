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

    public void scrollPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(a,b)", "");
    }
}