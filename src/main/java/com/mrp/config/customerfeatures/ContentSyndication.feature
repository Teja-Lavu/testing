@ContentSyndication
Feature: Content Syndication

Background: User is logged in
    Given user on the Login Page
    When user logs in successfully
    Then user navigates to Content Syndication page

Scenario: verify contents of page
Then verify the contents of Content Syndication page
 | Content Syndication | Top Countries | Employees | View Filters | TimeFrame dropdown | Export Leads |
When user select Time Frame "Last 365 Days" 
And click view filter
And User selects criteria
 | Employees | Greater  | 0            |
And click apply filter
Then verify TopCountries Graph is visible
And verify Employees graph is visible
When user click on Open Survey questions 
Then verify popup opens 
And click on X to close
When user click on Domain hyperlink 
Then verify if user navigates to domain page
When user click on Asset URL
Then verify if user navigates to success page
When user click on Export Leads 
Then verify Leads excel sheet is downloaded
When user click on any account hyperlink
Then verify if user navigates to Accounts Overview page