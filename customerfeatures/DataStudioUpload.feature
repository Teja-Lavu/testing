@Upload @Customer
Feature: DataStudio upload

  Background: User is logged in
    Given user on the Login Page
    When user logs in successfully
     When user Clicks on user logo button
    Then Switch company drop down should be displayed
    When user clicks on switch company drop down
    And user selects a company from the Switch drop down for Data Studio     
    Then a pop up message should be displayed
    When user clicks on yes button

  @Smoke @Regression
  Scenario: Navigate to upload file   
    Given User Clicks on DataStudio
    And User clicks on Create List
    And User select Account List and continue
    And User select Upload file and continue
    And User select document to upload and continue
    And User Enter List name as "Pre-Test" and Finish
    And User go back to all lists
    Then Verify if a list is created
    And user verify the file have accounts and locations
    When user click on list
    Then user should be navigated to Accounts page
    And user should see accounts

  @Regression
  Scenario: Validations
    Given User Clicks on DataStudio
    And User clicks on Create List
    And User select Account List and continue
    And user clicks on Go Back
    And User select continue
    And check if the Discover prelytic data module is enabled
    And User select Upload file and continue
    And User select document to upload and continue
    And check user able to click on finish button without giving listname
    And User Enter List name as "montreal0" and click Finish
    And User should see validation message "This list name is already in use."
    And User Enter List name as "Pre-Test" and Finish
    When User go back to all lists
    Then Search for the file in searchbar
