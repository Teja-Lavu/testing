@account @Customer
Feature: Verifying accounts page

  Background: User is logged in
    Given user on the Login Page
    When user logs in successfully
    Given User is on account page

  @Regression
  Scenario: User filter with Accounts header
    And verify functionality of search bar with "The Rock"
    And Verify all the input fields are visible and selectable in sort by with "Account Z-A"
    And Verify all time periods are visible and selectable with "Last 7 days"
    And User selects criteria
      | Revenue | Greater  |     500 |
      | Country | Excludes | Albania |
    And click apply filter
    Then Print number of record

  @Smoke @Regression
  Scenario: Use filter panel to filter
    And verify functionality of search bar with "The Rock"
    And Verify all the input fields are visible and selectable in sort by with "Account Z-A"
    And Verify all time periods are visible and selectable with "Last 7 days"
    And User selects criteria
      | Employees | Greater | 3 |
    And click apply filter
    And Add filter
    And clear filter values
    And click hide filter
    And click view filter
    And User selects criteria
      | Employees | Greater | 3 |
    And click apply filter
    Then Print number of record

  @Regression
  Scenario: User delete filter
    And User selects criteria
      | Country   | Excludes | Albania |
      | Employees | Greater  |       3 |
    And click apply filter
    And delete added filter
    Then Print number of record

  @Regression
  Scenario: User Save Filter
    And User selects criteria
      | Employees | Greater | 3 |
    And User clicks on Save Filter
    And User Should see the popup to enter Filter name
    And User enter Filter Name as "QA Test"
    And User Clicks Save and Apply filter Button
    And click apply filter
    Then Print number of record

  @Regression
  Scenario: User select an account location
    When user select an account from list
    And click on arrow
    Then user should see a table containing
      | Location | Score + Topics | Address |
    When user cliks on location
    Then user should be redirected to Account Intelligence page

  @Regression
  Scenario: Export file
    When user click on Export button
    Then a popup appears
    When user click on export on popup to confirm
    Then user should see a message
      | Your file is being generated! | Keep an eye on your emails. Soon you'll receive a link to download your file. |
    And user clicks on close window button
