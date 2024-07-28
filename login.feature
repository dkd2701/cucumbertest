
Feature: Login functionality 

Background:  

Given User should be on login page 

  
  Scenario: TC_01_Valid_Login
    When User enter the valid credentials
    Then User shoud be navigated to home page 
    And User can see the logout link 
    
    
    Scenario: TC_02_Invalid_Login
    When User enter the Invalid credentials
    Then User can see error message
    
   @Deepak
    Scenario Outline: TC_04_Invalid_Login_data_driven
    When User enter the Invalid userid as "<userid>" and password as "<password>"
    Then User can see error message
    Examples: 
      | userid  | password |
      | aw1     |   pw1    |
      | aw2     |   pw2    |
      | aw2     |   pw2    |

    
    
    
    
    
    

  