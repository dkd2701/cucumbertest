Feature: Lead functionality 

Background:  
Given User should be on login page
When User enter the valid credentials 

  @Only
  Scenario:TC_04_Create_lead
  When user fills the mandatory fields as "<lname>" and "<comp>"
  | lname  | comp |
  | aw1     |   pw1 |

  Then lead should be created successfully 
  And click on logout
  
  