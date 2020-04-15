package com.vytrack.pages.fleet;

import com.vytrack.pages.AbstracPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehiclesPage extends AbstracPageBase {



    @FindBy(partialLinkText = "Create Car")
    private WebElement createCar;

    public void clickCreateCar(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();


    }
}
