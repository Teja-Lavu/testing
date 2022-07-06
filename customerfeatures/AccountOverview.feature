@AccountOverview @Customer
Feature: Accounts Overview


Background: User is logged in		
Given user on the Login Page
When user logs in successfully
Given User is on account page

@Smoke @Regression
Scenario: Verify contents of page
And User selects an account from list
And User is on OverView Tab
Then Verify the Account name 
And Verify the contents of the Overview page
  | TOP ACCOUNT SCORE | ACCOUNT ACTIVITY | SUMMARY |
  
  @Regression
 Scenario: Top Account Score Widget
 And User selects an account from list
 Then Verify Top Account score widget contents
  | CanvasChart | Composition | Fitness | Implicit Intent | Engagement | Topic | Location |  
  And Verify data for Topic and Location
  
  @Regression
 Scenario: Account Activity
  And Verify all time periods are visible and selectable with "Last 365 days"
  And User selects criteria  
  | Site Visits | Greater Than | 0 |
  | Impressions | Greater Than | 0 |
  | Employees   | Greater Than | 0 |
  And click apply filter
  And click hide filter
  And select an account from result
 Then Verify the Account Activity widget
  | Display Clicks | Display Impressions | Website Visits | Content Syndication | Sales Development | Calender Selection | 
  And user will change dates 
  And verify graph changes in Account Activity chart
  And Verify graph changes days to weeks when dates are given more than a month
  
 @Regression
Scenario: Summary
And User selects an account from list
Then Verify if all the sections are visible in summary Widget
  
  
  


