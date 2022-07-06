@CompanySwitcher @Customer
Feature: Switch Company

  Background: User is logged in
    Given user on the Login Page
    When user logs in successfully

  @Smoke @Regression
  Scenario: Switch Company drop down
    When user Clicks on user logo button
    Then Switch company drop down should be displayed
    And verify the default company which is displayed      
    When user clicks on switch company drop down
    When user selects a company from the Switch drop down
      | QA Test Company1 |      
    Then a pop up message should be displayed
    And verify the text on the modal window
      | Are you sure you want to act on behalf of |
    When user clicks on yes button
    Then Page should be redirected to selected account page
      | QA Test Company1 |
      | QA Company |
    And user clicks on no button
    Then page should not be redirected and should stay on previous account
      | QA Test Company1 |
      | QA Company |
