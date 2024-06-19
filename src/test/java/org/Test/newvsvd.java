package org.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class newvsvd {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://smallseotools.com/plagiarism-checker");
        WebElement upload =driver.findElement(By.xpath("//span[@id='file_upload_status']"));

        System.out.println(upload);
        upload.sendKeys("C:\\Users\\user\\Desktop\\functionalsample.pdf");


    }
}
