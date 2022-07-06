@Location @Customer
Feature: Account Locations Tab

  Background: User is logged in
    Given user on the Login Page
    When user logs in successfully
    And User click accounts
    #And verify functionality of search bar with "Nacro"
    And User select an account from list
    And User navigates to the Locations tab

  @Smoke @Regression
  Scenario: Verification of locations tab
    Then Verify the contents of the Location page
      | Location | Topic | SCORE + TOPIC | ADDRESS | ACTION |
    And Verify the items of Location dropdown  has all the addresses of all topics on page
    When user selects an address from location drop down
    Then verify if the selected address is show in the results
    And Verify the items of Topics dropdown
      | Digital Signage | Video Conferencing | Wireless Access Points | Tablet/Mobile Devices | Legal Research Tool | Multi-Factor Authentication | Managed Security Operation Center | Hot Data Storage | Application Performance Monitoring | Data Analytics | SD-WAN | General Compliance Management | Investing Tools | Lending & Financing | Anti-Virus | Physical Server | SAN |
    When user selects topic from dropdown
    Then verify if related locations are displayed
    When user click on view location link for a given location
    Then User navigates to Intelligence Tab
    
