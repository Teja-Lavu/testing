@PerformanceDashboard
Feature: Performance Dashboard

Background: User is logged in		
Given user on the Login Page
When user logs in successfully
Then user navigates to performance Dashboard page

@Regression
Scenario: Verify contents of the page
And verify the contents of Performance Dashboard page
  | Performance Dashboard | View Filters | TimeFrame dropdown | Accounts | Accounts W/INTENT | Site Visits | Orchestration | Top Accounts |
 
 @Regression 
Scenario: Filter Accounts 
When user select Time Frame "Last 365 Days" 
And click view filter
And User selects criteria
| Revenue    | Greater | 100 |
| Employees | Greater  | 0            |
Then verify the Number of Accounts filtered in Accounts Widget

@Regression
Scenario: Verify Orchestration widget
When user select Time Frame "Last 365 Days"
And verify the contents of Orchestration widget
 | Average | Total | Impressions | Site Visits | Content Syndication Leads | Sales Development Leads |
Then verify the Impressions and Site visits charts are visible
And verify the number of Content Syndication Leads and Sales Development Leads

@Regression
Scenario: Verify the contents of Accounts W/INTENT
Then verify the number of Accounts W/Intent
And verify the % is visible
And verify the Accounts W/Intent graph is visible in widget

@Regression
Scenario: verify the Contents of Site Visits Widget
Then verify the Number site visits
And verify the % site visits is visible
And verify the Site visits graph is visible

@Smoke @Regression
Scenario: Top Accounts Widget
Then verify the contents of Top Accounts widget
| Account | Score + Topic | Location |
And verify the number of records
And verify if the Account link is clickable
When user click on a Account
Then user should be navigated to Account Intelligence Tab

