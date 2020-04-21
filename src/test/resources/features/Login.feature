@login
Feature: Login
  As user, I want to be able to login with username and password
  # Agile story
  #Test = Test Case =Scenario
  #Test + Dataprovider =Scenario Scenario Outline line +Examples table
  Background: open login page
    Given user is on the landing page

  @sales_manager
  Scenario:Login as sales manager and verify that title is Dashboard
    When user logs is as a sales manager
    Then user should verify that title is a Dashboard

  @store_manager
  Scenario:Login as store manager and verify that title is Dashboard
    When user logs is as a store manager
    Then user should verify that title is a Dashboard

  @driver @dashboard
  Scenario: Login as track Driver and verify that title is Dashboard
    When user logs is as a track driver
    Then user should verify that title is a Dashboard

    @login_with_params
    Scenario: login with parameter
      When user enters "salesmanager115" username and "UserUser123" password
      Then user should verify that title is a Dashboard
