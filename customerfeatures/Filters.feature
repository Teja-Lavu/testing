@Filter
Feature: Account Filter

  Background: User is logged in
    Given user on the Login Page
    When user logs in successfully
    Then User is on account page

  @Regression
  Scenario: Filter country excludes
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Country | Excludes | Albania |
    And click apply filter
    Then verify the result Country Excludes Albania

  @Regression
  Scenario: Filter country includes
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Country | Includes | Albania |
    And click apply filter
    Then verify the result Country Includes Albania

  @Regression
  Scenario: Filter Region excludes
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Region | Excludes | Abia, Nigeria |
    And click apply filter
    Then verify the result Region Excludes Abia Nigeria

  @Regression
  Scenario: Filter Region includes
    Then select "365 days" from timeframe dropdown
    And User selects criteria
      | Region | Includes | Abia, Nigeria |
    And click apply filter
    Then verify the result Region Includes Abia Nigeria

  @Regression
  Scenario: Filter City excludes
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | City | Excludes | Aba, Abia |
    And click apply filter
    Then verify the result City Excludes Abia

  @Regression
  Scenario: Filter City includes
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | City | Includes | Aba, Abia |
    And click apply filter
    Then verify the result City Includes Abia

  @Regression
  Scenario: Filter Employees Greater Than
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Employees | Greater Than | 1 |
    And click apply filter
    Then verify the result Employees Greater Than 1 filtered

  @Regression
  Scenario: Filter Employees Less Than
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Employees | Less Than | 100 |
    And click apply filter
    Then verify the result Employees Less Than 100 filtered

  @Regression
  Scenario: Filter Revenue Greater Than
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Revenue | Greater Than | 100 |
    And click apply filter
    Then verify the result Revenue Greater Than 100 filtered

  @Regression
  Scenario: Filter Revenue Less Than
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Revenue | Less Than | 1000 |
    And click apply filter
    Then verify the result Revenue Less Than 1000 filtered

  @Regression
  Scenario: Filter List includes
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | List | Includes | Top 3 Accounts |
    And click apply filter
    Then verify the result List includes Top Three Accounts filtered

  @Regression
  Scenario: Filter Topic includes
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Topic | Includes | Supply Chain |
    And click apply filter
    Then verify the result Topic Includes ABM filtered

  @Regression
  Scenario: Filter Topic score Greater Than
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Topic Score | Greater Than | 50 |
    And click apply filter
    Then verify the result Topic Score Greater Than 50 filtered

  @Regression
  Scenario: Filter Topic score Less Than
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Topic Score | Less Than | 50 |
    And click apply filter
    Then verify the result Topic Score Less Than 50 filtered

  #@Regression
  #Scenario: Filter KeyTerm Exposure excludes
  #And select "365 days" from timeframe dropdown
  #And User selects criteria
  #| KeyTerm | Excludes | Abia Nigeria |
  #And click apply filter
  #Then verify the result does not contain region filtered
  #
  #@Regression
  #Scenario: Filter KeyTerm Exposure includes
  #And select "365 days" from timeframe dropdown
  #And User selects criteria
  #| KeyTerm Exposure | Includes | Abia Nigeria |
  #And click apply filter
  #Then verify the result contains Key Term Exposure filtered
  @Regression
  Scenario: Filter Site Visits Greater Than
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Site Visits | Greater Than | 0 |
    And click apply filter
    Then verify the result Site Visits Greater Than 0 filtered

  @Regression
  Scenario: Filter Site Visits Less Than
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Site Visits | Less Than | 50 |
    And click apply filter
    Then verify the result Site Visits Less Than 50 filtered

  #Where to see result
  #@Regression
  #Scenario: Filter Display Tactic excludes
  #And select "365 days" from timeframe dropdown
  #And User selects criteria
  #| Display Tactic | Excludes | sc test qa |
  #And click apply filter
  #Then verify the result Display Tactic Excludes sc test qa filtered
  #
  #@Regression
  #Scenario: Filter Display Tactic includes
  #And select "365 days" from timeframe dropdown
  #And User selects criteria
  #| Display Tactic | Includes | sc test qa |
  #And click apply filter
  #Then verify the result Display Tactic Excludes sc test qa filtered
  #
  @Regression
  Scenario: Filter Impressions Greater Than
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Impressions | Greater Than | 0 |
    And click apply filter
    Then verify the result Impressions Greater Than 0 filtered
    
  @Regression
  Scenario: Filter Impressions Less Than   
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Impressions | Less Than | 50 |
    And verify functionality of search bar with "Southern Cross Electrical Engineering Limited"
    And click apply filter
    Then verify the result Impressions Less Than 50 filtered

  @Regression
  Scenario: Filter Clicks Greater Than
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Clicks | Greater Than | 1 |
    And click apply filter
    Then verify the result Clicks Greater Than 1 filtered

  @Regression
  Scenario: Filter Clicks Less Than
  And verify functionality of search bar with "Telstra"
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Clicks | Less Than | 10 |
    And click apply filter
    Then verify the result Clicks Less Than 10 filtered

  @Regression
  Scenario: Filter Industry excludes
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Industry | Excludes | Media and Entertainment |
    And click apply filter
    Then verify the result Industry Excludes Media and Entertainment filtered

  @Regression
  Scenario: Filter Industry includes
    And select "365 days" from timeframe dropdown
    And User selects criteria
      | Industry | Includes | Media and Entertainment |
    And click apply filter
    Then verify the result Industry includes Media and Entertainment filtered
