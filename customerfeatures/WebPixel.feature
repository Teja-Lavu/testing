#@webpixel
#Feature: Create web pixel
#
  #Background: User is logged in
    #Given user on the Login Page
    #When user logs in successfully
    #And user clicks on admin studio icon
    #And user clicks web pixel from admin studio
#
  #@Regression @Smoke
  #Scenario: Add a web pixel
    #And user clicks on web pixel from admin studio
    #Then “Install web pixel” page should be displayed
    #And Create a pixel button should be displayed
    #When user clicks on create a pixel button
    #Then “Data Studio | Create a Pixel” page should be displayed
    #And upload your website’s sitemap page should be displayed
    #And “upload file” button should be displayed
    #And “download template file” link should be displayed
    #When user clicks on “download template file” link
    #Then sitemap.csv template should be downloaded
    #When user clicks on “How to install the MRP Prelytix Web pixel” link
    #Then user should be navigated to new window page
    #When user clicks on “Go Back” button
    #And user should be navigated to home page
    #And user clicks on Create a pixel button
    #Then user should be navigated to create a pixel page
    #And continue button should be disabled
    #When user uploads a web pixel file
    #Then continue button should be enabled
    #When user clicks on continue button
    #And user should be navigated to “Confirm your sitemap below.” page
    #Then “Add row” button should be displayed
    #And search bar should be displayed
    #And edit section should be displayed and it should be disabled
    #And mark all active button be displayed and it should be disabled
    #And delete all button should be displayed and it should be disabled
    #When user clicks on “Add Row” button
    #Then URL field should be displayed
    #When user enters the Url Field as https://www.google.com
    #And user enters the section as “google”
    #And click on continue button
    #Then new URL field should be created
    #When user clicks on “Add Row” button
    #Then URL field should be displayed
    #When user enters the Url Field as https://maps.com
    #And click on continue button
    #Then error message should be displayed as “You have 1 URL with an incorrect format. All URLs require a protocol (ex. https://) and subdomain (ex. www.).”
    #When delete the row which is created in previous step
    #And user selects two rows
    #Then “Edit Section” button should be enabled
    #When click on edit section button
    #Then editing 2 sections window should be displayed
    #And cancel button should be displayed
    #And “Set” button should be displayed and it should be disabled
    #When user enters the text in edit section field
    #And click on cancel button
    #Then user should be navigated to web pixel details page
    #When user selects two rows “Edit Section”button should be enabled
    #And click on edit section button
    #And enter the text in edit section field
    #And click on set button
    #Then the section name for two fields should be changed
    #When user selects two rows
    #Then “Mark all active” button should be enabled
    #And user clicks on “Mark all active” button
    #Then the two selected rows should be in active mode
    #When user selects two rows
    #Then “Delete all” button should be enabled
    #And user clicks on “Delete all” button
    #Then “Are you sure you want to delete 2 rows” pop up window should be displayed
    #And user clicks on “yes” button
    #Then two selected URL’s should be deleted
    #When user clicks on “delete” link under site map instructions
    #Then a pop window should be displayed as “Are you sure you want to delete 1 row”
      #| yes |  | no |
    #When user clicks on “no” button
    #Then user should be navigated to web pixel details page
    #When user clicks on “delete” link under site map instructions
    #Then a pop window should be displayed as “Are you sure you want to delete 1 row”
      #| yes |  | no |
    #When user clicks on “yes” button
    #Then the selected row should be deleted
    #When provided with some text in the search criteria
    #Then verify if search is working fine
    #When we click on continue button
    #Then “Great job, you have successfully generated a Prelytix Pixel” page should be displayed
#
  #@Regression
  #Scenario: Existing web pixel
    #When user clicks on web pixel from admin studio
    #Then Web Pixel Details page should be displayed
    #And pixel code should be displayed
    #And view setup instructions button should be displayed
    #When we click on view setup instructions button
    #Then Install the MRP Prelytix Web Pixel page should be displayed in new window
    #When user clicks on click to copy button
    #Then the link should be changed to copied
    #And verify site map buttons should be enabled
      #| save | Download | Upload | Add Row |
    #And search rows bar should be displayed
    #And verify the buttons should be displayed and disabled
      #| Edit section | Mark all active | Delete All |
    #When user clicks on “Add Row” button
    #Then URL field should be displayed
    #When user enters the Url Field as https://www.google.com
    #And user enters the section as “google”
    #And click on continue button
    #Then new URL field should be created
    #When user clicks on “Add Row” button
    #Then URL field should be displayed
    #And user enters the Url Field as https://maps.com
    #And click on continue button
    #Then error message should be displayed as “You have 1 URL with an incorrect format. All URLs require a protocol (ex. https://) and subdomain (ex. www.).”
    #When user selects two rows
    #Then “edit section” button should be enabled
    #When click on edit section button
    #Then editing 2 sections window should be displayed
    #And cancel button should be displayed
    #And “Set” button should be displayed and it should be disabled
    #When enter the text in edit section field
    #And click on cancel button
    #Then user should be navigated to web pixel details page
    #When user selects two rows
    #Then “Edit Section” button should be enabled
    #When click on edit section button
    #And enter the text in edit section field
    #And click on set button
    #Then the two fields should be changed
    #When user selects two rows
    #Then “Mark all active” button should be enabled
    #And user clicks on “Mark all active” button
    #Then the two selected rows should be in active mode
    #When user selects two rows
    #Then “Delete all” button should be enabled
    #When user clicks on “Delete all” button
    #Then “Are you sure you want to delete 2 rows” pop up window should be displayed
    #And the window should be displayed with “yes” and “no” buttons
    #When user clicks on “no” button
    #Then the selected URL’s should be deleted
    #And user should be navigated to web pixel details page
    #When user selects two rows
    #Then “Delete all” button should be enabled
    #When user clicks on “Delete all” button
    #Then “Are you sure you want to delete 2 rows” pop up window should be displayed
    #When user clicks on “yes” button
    #Then two selected URL’s should be deleted
    #When user clicks on “delete” link under site map instructions
    #Then a pop window should be displayed as “Are you sure you want to delete 1 row”
      #| yes |  | no |
    #When user clicks on “no” button
    #Then user should be navigated to web pixel details page
    #When user clicks on “delete” link under site map instructions
    #Then a pop window should be displayed as “Are you sure you want to delete 1 row”
      #| yes |  | no |
    #When user clicks on “yes” button
    #Then the selected row should be deleted
    #Then Provide some text in the search criteria
    #Then verify if search is working fine
