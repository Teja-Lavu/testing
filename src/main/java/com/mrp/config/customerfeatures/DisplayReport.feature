@DisplayReport
Feature: Performance Dashboard

  Background: User is logged in
    Given user on the Login Page
    When user logs in successfully
    Then user navigates to Display Report page

  @Regression
  Scenario: Verify contents of the page
    And verify the contents of Display Report page
      | Display Report | Impressions | Account Reach | Cost Analysis | Clicks | Click-Through Rate | Site Lift | View Filters | Last 7 days |

@Smoke @Regression
  Scenario: Verify the Accounts
    And verify Impressions,Clicks and Click through Rate numbers are visible
    And verify the Total number of accounts
    When user select Time Frame "Last 365 Days"
    And click view filter
    And User selects criteria
      | Employees | Greater | 0 |
    And click apply filter
    Then verify Impressions,Clicks and Click through Rate are changed

@Regression
  Scenario: Verify the graphs
    And verify Impressions percentage and graph are visible
    And verify Account reach chart and number of accounts are visible
    And verify Cost Analysis graph is visible
    And verify Clicks graph and percentage are visible
    And verify Click-Through Rate and percentage are visible
    And verify Site Lift graph is visible
