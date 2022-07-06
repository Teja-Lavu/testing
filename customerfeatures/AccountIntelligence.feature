  @Intelligence 
 Feature: Data Studio

  Background: User is logged in
    Given user on the Login Page
    When user logs in successfully
    Given User is on account page
    And User select an account
    And user navigate to Intelligence Tab

  @Regression 
  Scenario: Verify contents of page
    Then user verify the contents of the page
      | Location | Topic | Time Frame | ACCOUNT SCORE | TOP KEY TERMS | TOP VENDOR EXPOSURE | WEBSITE ACTIVITY |

  @Regression  
  Scenario: Verify account score widget
    And select a Topic to see account score
    And Verify if account score is visible
    And Veirfy if bar chart is visible

  @Regression 
  Scenario: Verify Top Key Terms widget
    Then select "365 days" from timeframe dropdown
    And select "All topics" from Topic dropdown
    And verify data is shown in top key terms widget

  @Regression 
  Scenario: Verify TOP VENDOR EXPOSURE
    Then select "365 days" from timeframe dropdown
    And select "All topics" from Topic dropdown
    And Verify TOP VENDOR EXPOSURE widget showing data

  #@Regression
  #Scenario: Verify Campaign engagement Widget
    #Then select "365 days" from timeframe dropdown
    #And select "All topics" from Topic dropdown
    #And Verify contents of the widget
      #| CAMPAIGN | CREATIVES | IMPRESSIONS | CLICKS |
    #And Verify if any data shown

  @Regression 
  Scenario: Verify Website activity widget
    Then select "365 days" from timeframe dropdown
    And select "All topics" from Topic dropdown
    And verify the contents for the widget
      | PAGE | VISITS | LAST VISIT DATE |
    And verify data shown in the widget

  @Regression @Smoke
  Scenario: Verify the Intelligence Tab Details
    Then user verify the contents of the page
      | Location | Topic | Time Frame | ACCOUNT SCORE | TOP KEY TERMS | TOP VENDOR EXPOSURE | WEBSITE ACTIVITY |  
    And select an item from topic dropdown
    And verify the result is shown
    And select "All topics" from Topic dropdown
    Then select "365 days" from timeframe dropdown
    And verify data is shown in top key terms widget
    And Verify TOP VENDOR EXPOSURE widget showing data
    And verify data shown in the widget
