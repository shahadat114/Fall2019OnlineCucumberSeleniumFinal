package com.vytrack.pages.activities;


import com.vytrack.pages.AbstracPageBase;
import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarEventsPage extends AbstracPageBase {

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(css = ".select2-chosen")
    private WebElement owner;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;


    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columsName;

    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    private WebElement descriptionFrame;

    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;

    @FindBy(id = "tinymce")
    private WebElement descriptionTextArea;

    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;

    @FindBy(xpath = "//label[text()='Description']/following-sibling::div//div")
    private WebElement generalInfoDescription;

    @FindBy(xpath = "//*[contains(text(),'View per page:')]/following-sibling::*//a")
    private List<WebElement> viewPerPageElements;
    @FindBy(css = "button[class*='btn dropdown-toggle']")
    private WebElement viewPerPageToggle;

    public List<String> getViewPerPageOptions() {
        BrowserUtils.wait(4);
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Create Calendar event']")));
        viewPerPageToggle.click();
        BrowserUtils.wait(4);
        return BrowserUtils.getTextFromWebElements(viewPerPageElements);
    }

    public void enterCalendarEventTitle(String titleValue) {
        BrowserUtils.wait(3);
        BrowserUtils.waitForPageToLoad(25);
        BrowserUtils.wait(7);
        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);
        wait.until(ExpectedConditions.attributeToBe(title, "value", titleValue));
//        wait.until(ExpectedConditions.attributeToBe())
    }

    public void enterCalendarEventDescription(String description) {
        //wait until frame is available and switch to it
        //BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        descriptionTextArea.sendKeys(description);
        wait.until(ExpectedConditions.textToBePresentInElement(descriptionTextArea, description));

        driver.switchTo().defaultContent();//exit from the frame
    }

    public String getGeneralInfoTitleText() {
        BrowserUtils.wait(2);
        BrowserUtils.waitForPageToLoad(20);
        return generalInfoTitle.getText();
    }

    public String getGeneralInfoDescriptionText() {
        BrowserUtils.wait(2);
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Description']/following-sibling::div//div")));
        return generalInfoDescription.getText();
    }

    public List<String> getColumNames() {
        BrowserUtils.wait(2);
        BrowserUtils.waitForPageToLoad(15);
        return BrowserUtils.getTextFromWebElements(columsName);
    }

    public String getOwnerName() {
        BrowserUtils.wait(2);
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();

    }

    public void clickToCreateCalendarEvent() {
        BrowserUtils.wait(2);
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Create Calendar event']")));
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
        BrowserUtils.waitForPageToLoad(20);
    }

    public String getStartDate() {
        BrowserUtils.wait(2);
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.scrollTo(startDate);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        return startDate.getAttribute("value");

    }

    public String getStartTime() {
        BrowserUtils.wait(2);
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }

    public String getEndTime() {
        BrowserUtils.wait(2);
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");
    }
}
