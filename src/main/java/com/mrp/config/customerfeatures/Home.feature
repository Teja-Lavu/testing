@Home @Customer
Feature: Home

  Background: User is logged in
   Given user on the Login Page
    When user enters email address
      | rmettu@mrpfd.com |
    And user enters password
      | Raji1892 |
    And user clicks the sign in button
    Then user should login successfully and land on Customer Home page
    
   Scenario: Verify contents of Home page
   And Verify the contents of the Home page
      | Account Reach | Tactic Performance | Average Topic Score | Acivity | Top Accounts |
      
    Scenario: Average Topic Score widget
    When user clicks on topic
    Then user should be redirected to accounts page
    And verify the accounts list has clicked topic filtered
    And user comes back to Home page
    And user should see average score in the widget
    When user clicks on View distribution Hyperlink
    Then user should see Topic Score Distribution PopUp
    And user should see bar chart and Share of voice,vendors
    When user clicks on close button
    Then user should be redirected to Home page
    
    Scenario: Top Accounts Widget    
    When user sort accounts by ascending order
    Then verify the accounts are sorted in ascending order
    When user sort accounts by descending order
    Then verify the accounts are sorted in descending order
    When user select a topic from dropdown
    #Then verify accounts shown for the topic selected 
    And user select an account
    Then user should be redirected to intelligence tab   
    
    Scenario: Activity Widget
    When user select website click
    Then user should see results for website
    When user click on account
    Then user should be redirected to account overview 
    And user comes back to Home page
    When user select display click
    Then user should see results for display clicks
    
    #Scenario: Account Reach and tactic performance widget
    #When user click on a tactic
    #Then user should be redirected to display report page
    
    