@create_company
Feature: Create Company

  Background: User is logged in
   Given user on the Login Page
    When user logs in successfully
    And user will click Admin icon
    And user will click Companies
    And user will click create new button

  @Regression
  Scenario: Navigate to new company    
    Then user should see New Company page

  @Regression
  Scenario: Verify input boxes and validations
    And user will enter CompanyName with "@123"
    And user will select FiscalYearStart with "12/12"
    And clear the entered values
    Then verify if the save button is disabled

  @Smoke @Regression
  Scenario: Create new company
    And user will enter CompanyName with "Test"
    And user will select FiscalYearStart with "12/21"
    And user will select Client Account ID
    And user will click create button
    Then verify the company list if it is created