package com.vytrack.step_definitions;

import com.google.gson.internal.$Gson$Preconditions;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.activities.CalendarEventsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class CreateCalendarEventStepDefination {


    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Then("user clics on create calendar event button")
    public void user_clics_on_create_calendar_event_button() {
        System.out.println("user clicks on create calendar event button");
        calendarEventsPage.clickToCreateCalendarEvent();
    }

    @Then("user enters {string} as title")
    public void user_enters_as_title(String string) {
        System.out.println("user enter titile: " + string);
        calendarEventsPage.enterCalendarEventTitle(string);

    }


    @Then("user enters {string} as s description")
    public void user_enters_as_s_description(String string) {
        System.out.println("user enter description: " + string);
        calendarEventsPage.enterCalendarEventDescription(string);
    }


    @Then("user click on save and close button")
    public void user_click_on_save_and_close_button() {
        System.out.println("user click save and close button");
        calendarEventsPage.clickOnSaveAndClose();
    }

    //    @Then("user verifies that description is {string}")
//    public void user_verifies_that_description_is(String string) {
//
//        Assert.assertEquals(string,calendarEventsPage.getGeneralInfoDescriptionText());
//    }
//
//    @Then("user verifies thta title of new calaendar event is\"Sprint Retrospective\"")
//    public void user_verifies_thta_title_of_new_calaendar_event_is_Sprint_Retrospective() {
//   Assert.assertEquals(,calendarEventsPage.getGeneralInfoTitleText());
//
//    }
    @Then("user verifies that description is {string}")
    public void user_verifies_that_description_is(String string) {
        Assert.assertEquals(string, calendarEventsPage.getGeneralInfoDescriptionText());
    }

    @Then("user verifies thta title of new calaendar event is {string}")
    public void user_verifies_thta_title_of_new_calaendar_event_is(String string) {
        Assert.assertEquals(string, calendarEventsPage.getGeneralInfoTitleText());
    }

    @Then("user enters new calendar event information:")
    public void user_enters_new_calendar_event_information(Map<String, String> dataTable) {
        calendarEventsPage.enterCalendarEventDescription(dataTable.get("description"));
        calendarEventsPage.enterCalendarEventTitle(dataTable.get("title"));


    }

    @Then("user verifies new calendar event was created successfully")
    public void user_verifies_new_calendar_event_was_created_successfully(Map<String, String> dataTable) {
        Assert.assertEquals(dataTable.get("description"), calendarEventsPage.getGeneralInfoDescriptionText());
        Assert.assertEquals(dataTable.get("title"),calendarEventsPage.getGeneralInfoTitleText());

    }
}
