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

  @scenario_outline
  Scenario Outline: User names test for user <name>
    When user enters "<username>" username and "<password>" password
    Then user name should be "<name>"

    Examples: credentials
      | username        | password    | name             |
      | user187         | UserUser123 | Jerel Vandervort |
      | user200         | UserUser123 | Lonzo Leuschke   |
      | storemanager52  | UserUser123 | Roma Medhurst    |
      | storemanager66  | UserUser123 | Carlos Ernser    |
      | salesmanager125 | UserUser123 | Cleveland Heller |
      | salesmanager140 | UserUser123 | Jameson Paucek   |