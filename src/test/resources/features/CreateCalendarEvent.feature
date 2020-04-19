@activities
Feature: Create Calendar Even
  As user, I want to be able to create calendar events

  Scenario: Create calendar event as sales manager
    Given user is on the landing page
    When user logs is as a sales manager
    And user navigates to "Activities" and "Calendar Events"
    Then user clics on create calendar event button
    And user enters "Sprint Retrospective" as title
    And user enters "on the this meeting discuss what we well, and what went wrong and can be improved" as s description
    Then user click on save and close button
    And user verifies that description is "on the this meeting discuss what we well, and what went wrong and can be improved"
    And user verifies thta title of new calaendar event is "Sprint Retrospective"

  @create_calendar_event_2
  Scenario: Create calendar event as sales manager
    Given user is on the landing page
    When user logs is as a sales manager
    And user navigates to "Activities" and "Calendar Events"
    Then user clics on create calendar event button

    And user enters new calendar event information:
      | description | on the this meeting discuss what we well, and what went wrong and can be improved |
      | title       | Sprint Retrospective                                                                |
    Then user click on save and close button
    And user verifies new calendar event was created successfully
      | description | on the this meeting discuss what we well, and what went wrong and can be improved |
      | title       | Sprint Retrospective                                                              |