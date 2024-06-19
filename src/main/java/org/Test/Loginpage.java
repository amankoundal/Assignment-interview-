package org.Test;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends ActionClass {

    public WebDriver driver;
    public Loginpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="timedragon_id_1842")
    private WebElement text;

    @FindBy(id="timedragon_id_1859")
    private WebElement id;

    @FindBy(id="timedragon_id_1867")
    private WebElement pass;

    @FindBy(id="timedragon_id_1874")
    private WebElement signIN;

    @FindBy(xpath = "//*[text()='Personal Information']")
    private WebElement checklogIn;
    public String getWelcomePageText(){
        waitElementVisible(text,10);
        String text1 =text.getText();
        return text1;
    }

    public void enterId(String empId){
        id.sendKeys(empId);
    }

    public void enterPassword(String password){
        pass.sendKeys(password);
    }

    public void clickOnSignIn() {
        signIN.click();
    }

    public String CheckLogIntoEmployAcc(){
        waitElementVisible(checklogIn,10);
       String text2 = checklogIn.getText();
       return text2;
    }


}

