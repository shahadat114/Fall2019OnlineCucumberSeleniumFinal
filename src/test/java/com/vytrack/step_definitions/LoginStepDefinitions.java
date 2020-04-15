package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        System.out.println("open the login page ");
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);


    }

    @When("user logs is as a sales manager")
    public void user_logs_is_as_a_sales_manager() {
        System.out.println("login as sales manager ");
        loginPage.login("salesmanager110","UserUser123");

    }

    @When("user logs is as a store manager")
    public void user_logs_is_as_a_store_manager() {
        loginPage.login("storemanager85","UserUser123");

    }

    @When("user logs is as a track driver")
    public void user_logs_is_as_a_track_driver() {
    loginPage.login("user19","UserUser123");
    }
    @Then("user should verify that title is a Dashboard")
    public void user_should_verify_that_title_is_a_Dashboard() {
        System.out.println("Verify the title is Dashboard");

        Assert.assertEquals("Dashboard",Driver.getDriver().getTitle());
        Driver.closeDriver();
    }
}
