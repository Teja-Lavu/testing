#@connect_connectors
#Feature: Connectors
#
  #Background: User is logged in
    #Given user on the Login Page
    #When user logs in successfully
    #And user clicks on data studio icon
    #And user clicks connectors from data studio
#
  #@Regression
  #Scenario: Check whether sales force  connector is displayed
    #Then verify sales force connector is displayed
    #And verify sales force logo is displayed
    #And verify “Salesforce is a leading enterprise customer relationship manager (CRM) application” text is displayed
    #And verify if  “Connect” button should be displayed for salesforce connector
    #And verify “Not connected” text should be disabled for salesforce connector
    #When we click on connect button trayio authentication window should be displayed
    #Then sales force authentication window should be displayed
    #When click on the finish button on trayio window
    #Then the status of the sales force connector should be in “Active”
    #And “Disconnect” button should be displayed for salesforce connector
    #When user clicks on disconnect button on the sales force connector
    #Then status should be in “Disconnect” mode
    #And button text should change to Connect
#
  #Scenario: Check whether Eloqua connector is displayed
    #Then verify Eloqua connector is displayed
    #And verify Eloqua logo is displayed
    #And verify “Eloqua is a software as a service (SaaS) platform for marketing automation offered by Oracle that aims to help B2B marketers and          	 organizations manage marketing campaigns and sales lead generation” text is displayed
    #And verify if  “Connect” button should be displayed for Eloqua connector
    #And verify “Not connected” text should be disabled for Eloqua connector
    #When user clicks on “Connect”button for Eloqua connector
    #Then Email window should be displayed
#
  #Scenario: Check whether HubSpot connector is displayed
    #Then verify HubSpot connector is displayed
    #And verify  HubSpot logo is displayed in blue colour
    #And verify “HubSpot is your all-in-one stop for all of your marketing software needs” text is displayed
    #And verify if  “Connect” button should be displayed for Hubspot connector
    #And verify “Not connected” text should be disabled for Hubspot connector
    #When user clicks on “Connect”button for Hubspot connector
    #Then Email window should be displayed
#
  #Scenario: Check whether Marketo connector is displayed
    #Then verify Marketo connector is displayed
    #And verify  Marketo logo is displayed in purple colour
    #And verify “Marketo is a marketing automation software helps marketers engage customers and prospects” text is displayed
    #And verify if  “Connect” button should be displayed for Marketo connector
    #And verify “Not connected” text should be disabled for Marketo connector
    #When user clicks on “Connect”button for Marketo connector
    #Then Email window should be displayed
