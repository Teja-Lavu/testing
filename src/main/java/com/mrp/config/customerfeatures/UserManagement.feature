@UserManagement
Feature: User management

  Background: User is logged in
    Given user on the Login Page
    When user logs in successfully
    And user navigates to Admin Studio page
    And user clicks on the users
    And user clicks on create user button

  @Regression
  Scenario: Verify the components of User
    Then verify the contents of the page
      | First Name* | Last Name* | Email* | Password* | Role* | Create | Cancel |

  @Smoke @Regression
  Scenario: Company user created successfully
    And user enters first name
      | Rajya123 |
    And user enters last name
      | company user |
    And user enter email address
    And user enter password
      | Test!802 |
    And the user selects the company admin user role
    And click on the Create button
    Then verify if the user is created successfully
    
  @Smoke @Regression
  Scenario: Member user created successfully
    And user enters first name
      | Rajya123 |
    And user enters last name
      | member |
    And user enter email address
    And user enter password
      | Test!802 |
    And the user selects the member user role
    And click on the Create button
    Then verify if the user is created successfully

  @Regression
  Scenario: User form validation messages
    And user enters EMAIL address
      | tes@ |
    And user validates the error message for Email
      | Incorrect email format. |
    And user enters PASSWORD
      | Tes |
    And user validates the error message for Temporary Password
      | Password must be a minimum of 6 characters in length with at least 1 uppercase, 1 lowercase, 1 number, and 1 special character. |
    And verify Create button is disabled
