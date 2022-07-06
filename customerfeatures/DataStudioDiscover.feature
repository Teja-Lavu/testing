@Discover @Customer
Feature: Data Studio

  Background: User is logged in
    Given user on the Login Page
    When user logs in successfully

  @Regression
  Scenario: Create a List - items
    And The user navigates to the select a method page
    And They select the 'Discover Prelytix Data' Option on the List Method page
    And Verify the contents of the page
      | Status Bar | Geography | Limit Results | Industry | Annual Revenue | Employee count | Go back | Continue |

  @Regression
  Scenario: Annual Revenue selection
    And The user navigates to the select a method page
    And They select the 'Discover Prelytix Data' Option on the List Method page
    Then the inputs will display placeholder text
      | Enter minimum value in millions (USD) | Enter maximum value in millions (USD) |
    And verify the values present in the revenue minimum dropdown
      | Miniumum possible value | 1M | 50M | 100M | 250M | 500M | 1B |
    And verify the values present in the revenue maximum dropdown
      | Maximum possible value | 1M | 50M | 100M | 250M | 500M | 1B |
    When user enter minimum values "50M"  and maximum value "1M"
    Then verify the error message "Revenue minimum cannot be greater than or equal to maximum"
    And the continue button changes into an inactive state until the error is addressed
    When a user exceeds an allowed limit for a min/max field
    Then an error message pops up "The maximum value you can enter in this field is 5,000,000"
    When user clicks on the X icon after selecting minimum revenue value
    Then the selected value should be deleted and the min input should display place holder
    When user clicks on the X icon after selecting maximum revenue value
    Then the selected value should be deleted and the max input should display place holder

  @Regression
  Scenario: Geography
    And The user navigates to the select a method page
    And They select the 'Discover Prelytix Data' Option on the List Method page
    Then the inputs will display placeholder text
      | Begin typing to select a geography |
    And verify if the Geography is a searchable drop down
    And verify if the values are visible based on user selection
    And the Continue button should be enabled

  @Regression
  Scenario: Industry
    And The user navigates to the select a method page
    And They select the 'Discover Prelytix Data' Option on the List Method page
    Then the inputs will display Industry placeholder text
      | Select an option |
    And verify the values present in the Industry dropdown
      | Automotive | Construction | Consumer Goods | Education | Financial Services | Food, Beverage, and Agriculture | Forest Products | Healthcare | Industrial Products And Services | Information Technology | Manufacturing - Other | Media and Entertainment | Metals and Mining | Public Administration | Real Estate | Retail | Services - Other | Telecommunications | Transportation and Logistics | Utilities and Energy |
    When user inputs more than 1 value into the Industry drop down

  @Regression
  Scenario: Account HeadQuarters
    And The user navigates to the select a method page
    And They select the 'Discover Prelytix Data' Option on the List Method page
    Then the inputs will display placeholder text
      | Select Yes or No |
    And verify the values present in the headquarter dropdown
      | No | Yes |
    When user selects No from the drop down
    Then Limit Results drop down should not be displayed
    When user selects Yes from the drop down
    Then Limit Results drop down should be displayed
    And the inputs will display placeholder text
      | Select an option |
    And verify the values present in the headquarter dropdown again
      | All known locations | Headquarters only |

  @Regression
  Scenario: Employee selection
    And The user navigates to the select a method page
    And They select the 'Discover Prelytix Data' Option on the List Method page
    Then the inputs will display placeholder text
      | Enter a minimum value | Enter a maximum value |
    And verify the values present in the employees minimum dropdown
      | Minimum possible value | 500 | 1k | 5k | 10k | 50k | 100k |
    And verify the values present in the employees maximum dropdown
      | 500 | 1k | 5k | 10k | 50k | 100k | Maximum possible value |
    When user enter minimum value "100k" exceeds the maximum value "10k"
    Then the error message "Employee minimum cannot be greater than or equal to maximum" should be displayed
    And the continue button changes into an inactive state until the error is addressed
    When a user exceeds an allowed limit for a employee min/max field
    Then an employee error message pops up "The maximum value you can enter in this field is 5,000,000"
    When user clicks on the X icon after selecting minimum employee count "500"
    Then the selected value should be deleted and the employee min input should display place holder
    When user clicks on the X icon after selecting maximum employee count "10k"
    Then the selected value should be deleted and the employee max input should display place holder

  @Smoke @Regression
  Scenario: End to end dicover list creation
    When user Clicks on user logo button
    Then Switch company drop down should be displayed
    When user clicks on switch company drop down
    And user selects a company from the Switch drop down for Data Studio     
    Then a pop up message should be displayed
    When user clicks on yes button
    And The user navigates to the select a method page
    And They select the 'Discover Prelytix Data' Option on the List Method page
    And verify if the values are visible based on user selection
    And the Continue button should be enabled
    And user selects Yes from the drop down
    And Limit Results drop down should be displayed
    And user inputs more than 1 value into the Industry drop down
    And user enter minimum values "1M"  and maximum value "50M"
    And user enter minimum value "10k" exceeds the maximum value "100k"
    And User click Continue
    And User Enter list Name as "Pre-Test" and click Finish
    And Click all Lists to go back to list page
    Then Verify if a discover list is created
    And user verify the file have accounts and locations
    When user click on discover list
    Then user should be navigated to Accounts page
    And user should see accounts

