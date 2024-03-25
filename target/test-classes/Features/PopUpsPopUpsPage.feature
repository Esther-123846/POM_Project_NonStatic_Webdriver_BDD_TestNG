#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: PopUpsPage Feature
  
Background: 
		Given User is on Popups page 
  
  Scenario: Verify PopUps Page title
    When user gets the title of the page
    Then title of the page should be "Popups | Practice Automation"

 
  Scenario: Verify Alert PopUp
    When User clicks on Alert Popup button
    Then Alert popup message should be "Hi there, pal!"
   
