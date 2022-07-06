@create_subscription
Feature: Create subscription

  Background: User is logged in
    Given user on the Login Page
    When user logs in successfully
    And user clicks on admin studio icon
    And user clicks topics from admin studio

  @Regression
  Scenario: Add a subscription
    Then verify create subscription button is displayed
    When user clicks on the create subscription button
    Then verify "Subscribe to New Topics" pop up page is displayed
    And verify "Subscribe" button is disabled in the pop up page
    And verify cancel button is displayed
    And verify topics list is displayed by using drop down button
    When user selects "Account Management" from the topics list from topics drop down
    And click on subscribe button
    Then verify "A new topic subscription has been created!" pop up window is displayed
    And then verify "Close Window" button is displayed on the pop up window
    When click on close window button
    Then verify "Account Management" topic is displayed on the topic subscription page

  @Regression
  Scenario: Add two or more subscriptions
    When user clicks on the create subscription button
    And select "Accounts Payable" and "Accounts Receivable" and "Anti-Virus" from the topics list drop down
    And click on subscribe button
    Then verify "A new topic subscription has been created!" pop up window is displayed
    Then click on close window button
    And verify "Accounts Payable" and "Accounts Receivable" and "Anti-Virus"  topics are added on the topic subscription page

  @Regression
  Scenario: Selecting the topics form the list and clicking on cancel button
    When user clicks on the create subscription button
    And select "App Dev" from the topics list drop down
    And click on cancel button
    Then verify if "App Dev" topic is added to the list

  @Regression
  Scenario: Verifying "Unsubscribe" button
    When user clicks on the create subscription button
    And select "ABM"  from the topics list by using drop down button
    And click on subscribe button
    Then verify "A new topic subscription has been created!" pop up window is displayed
    Then click on close window button
    And verify "ABM" topic is displayed on topic subscription page
    And click on three dots icon
    Then verify "Unsubscribe" button is displayed
    When user clicks on unsubscribe button
    Then Verify "Are you sure you want to unsubscribe from ABM?" pop up is displayed
    And Verify "Cancel"  "Unsubscribe" button is displayed on the pop up window
    When we click on cancel button
    Then user should be navigated to topics subscription page
    And "ABM" topic should be displayed on the subscription page

  @Smoke @Regression
  Scenario: Unsubscribe "App Dev" from the topic subscriptions page
    When user clicks on the create subscription button
    And select "App Dev"  from the topics list by using drop down button
    And click on subscribe button
    Then verify "A new topic subscription has been created!" pop up window is displayed
    Then click on close window button
    And verify "App Dev" topic is displayed on topic subscription page AppDev
    And click on three dots icon AppDev
    Then verify "Unsubscribe" button is displayed
    When user clicks on unsubscribe button
    Then Verify "Are you sure you want to unsubscribe from App Dev?" pop up is displayed AppDev
    And Verify "Cancel"  "Unsubscribe" button is displayed on the pop up window
    When we click on "Unsubscribe" button
    Then verify pop up window should be displayed as "You have successfully unsubscribed"
    When verify "Click here" link is displayed on the pop up window
    And we click on "click here " link a pop up page should be displayed
    Then verify pop page as "Subscribe to New Topics" page is displayed
    And we Unsubscribe from all Subscribed topics
        | Account management | Accounts payable | Accounts Receivable | Anti Virus | ABM |