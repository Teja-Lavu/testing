@Login
Feature: Login page for customer portal

  Background: User is logged in
    Given user on the Login Page

  @Smoke @Regression
  Scenario: Successful Login
    When user enters email address
      | rmettu@mrpfd.com |
    And user enters password
      | Raji1892 |
    And user clicks the sign in button
    Then user should login successfully and land on Customer Home page

  #@Regression
  #Scenario: Unsuccessful login with invalid credentials
  #When user enters email address
  #| agou@mrpfd.com |
  #And user enters password
  #| Test80 |
  #And user clicks the sign in button
  #Then error message is displayed for invalid credentials
  #| Incorrect username or password. |
  #@Regression
  #Scenario: Unsuccessful login with empty credentials
  #When user clicks the sign in button
  #Then error message is displayed for empty credentials
  #| Please fill out this field. |
  
  @Logout @Regression
  Scenario: Successful LogOut
    When user enters email address
      | rmettu@mrpfd.com |
    And user enters password
      | Raji1892 |
    And user clicks the sign in button
    Then user Logs out from the Customer Application

  @Regression @Forgotpassword
  Scenario: Forgot password
    When user clicks on forgot password
    Then user should be redirected to forgot password page
    When user enters email address to reset password
      | rmettu@mrpfd.com |
    And click on reset password button
    Then user should be redirected to reset password page
