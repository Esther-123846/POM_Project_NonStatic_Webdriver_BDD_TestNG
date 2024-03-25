Feature: HomePage Feature
  
Background: 
		Given User is on Home page
  
  Scenario: Verify PopUps Page 
    When User clicks on Popups page link he lands on PopUps Page
    And user gets the title of the page
    Then title of the page should be "Popups | Practice Automation"

 
  Scenario: Verify FileUpload Page
    When User clicks on FileUpload page link he lands on FileUpload Page
    And user gets the title of the page
    Then title of the page should be "File Upload | Practice Automation"