package com.vytrack.step_definitions;

import com.vytrack.pages.fleet.VehiclesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CreateCarStepDefinitions {
    VehiclesPage vehiclesPage = new VehiclesPage();

    @Then("user clicks on create a car button")
    public void user_clicks_on_create_a_car_button() {
        System.out.println("user clicks on create a car button");
        vehiclesPage.clickToCreateCar();
    }
    @Then("user creates a car with following info:")
    public void user_creates_a_car_with_following_info(List<Map<String, String>> dataTable) {
        System.out.println("dataTable");
        for (Map<String, String> row : dataTable) {
            vehiclesPage.setLicencePlateInput(row.get("License Plate"));
            vehiclesPage.setDriverInput(row.get("Driver"));
            vehiclesPage.setLocationInput(row.get("Location"));
            vehiclesPage.setModelYear(row.get("Model Year"));
            vehiclesPage.setColor(row.get("Color"));
            //click to save ne car
            vehiclesPage.clickOnSaveAndClose();
        }
    }
    @And( "user verifies that car info is displayed")
    public void user_verifies_that_car_info_is_displayed(List<Map<String, String>> dataTable) {
        // Assert.assertEquals(vehiclesPage.getCarGeneralInfo("License Plate"),dataTable.get(0).get("License Plate"));
        for (Map<String, String> row : dataTable) {
            Assert.assertEquals(row.get("License Plate"), vehiclesPage.getCarGeneralInfo("License Plate"));
            Assert.assertEquals(row.get("Driver"), vehiclesPage.getCarGeneralInfo("Driver"));
            Assert.assertEquals(row.get("Location"), vehiclesPage.getCarGeneralInfo("Location"));
            Assert.assertEquals(row.get("Model Year"), vehiclesPage.getCarGeneralInfo("Model Year"));
            Assert.assertEquals(row.get("Color"), vehiclesPage.getCarGeneralInfo("Color"));
        }
    }
}
