package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstracPageBase {

    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;


    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;

    public String getWariningMessage(){
        return warningMessage.getText();
    }

    public void login(String usernameValue, String passwordValue){
        this.username.sendKeys(usernameValue);
        this.password.sendKeys(passwordValue,Keys.ENTER);
        BrowserUtils.wait(3);
    }
    /**
     * Method to login, version #2
     * Login as a default user
     * Credentials will be retrieved from configuration.properties file
     */

    public void login(){
       username.sendKeys(ConfigurationReader.getProperty("store_manager"));
       password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
       BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
    }

}
