Feature: FileUploadPage Feature
  
Background: 
		Given User is on FileUpload page
    
  
  Scenario: Verify FileUpload Page title
    When user gets the title of the page
    Then title of the page should be "File Upload | Practice Automation"
    
  Scenario: Upload file through Browse button
    And user uploads file through Browse button
    Then the file name after upload should be ""
    
  Scenario: Upload Using Robot Class
    And user uploads file Using Robot Class
    Then the file name after upload should be ""
    
    