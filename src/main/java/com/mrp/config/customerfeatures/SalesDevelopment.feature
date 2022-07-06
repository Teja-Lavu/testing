@SalesDevelopment
Feature: Sales Development

  Background: User is logged in
    Given user on the Login Page
    When user logs in successfully
    Then user navigates to Sales Development page

  @Regression @Smoke
  Scenario: SalesDevelopment Automation
    And verify the contents of Sales Development page
      | Sales Development | Top Countries | Employees | Export Leads | View Filters | TimeFrame dropdown |
    When user select Time Frame "Last 365 Days"
    And click view filter
    And User selects criteria
      | Employees | Greater | 0 |
    And click apply filter
    Then verify TopCountries Graph is visible
    And verify Employees graph is visible
    When user click on Open Survey questions in Sales Development
    Then verify popup opens in Sales Development
    And click on X to close
    When user click on Domain hyperlink in Sales Development
    Then verify if user navigates to domain page
    When user click on Export Leads
    Then verify Leads excel sheet is downloaded
    When user click on any account hyperlink
    Then verify if user navigates to Accounts Overview page
