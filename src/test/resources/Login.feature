@test
Feature: Login scenarios

Scenario Outline: Login with invalid username
    # Given I am on the login page- not using as we are already on login page
    When I enter username  as "username"
    And I enter password as "password"
    And click login button
    
    Then login should fail with error "<Error>"

    Examples: 
      | username | password | Error |
      | invalidUsername	| secret_sauce | Username and password do not match any user in this service. |
   
Scenario Outline: Login with invalid password
    # Given I am on the login page- not using as we are already on login page
   When I enter username  as "username"
    And I enter password as "password"
    And click login button
    
    Then login should fail with error "<Error>"

    Examples: 
      | username | password | Error |
      | standard_user	| invalidpassword | Username and password do not match any user in this service. |
      
      Scenario Outline: Login with valid username and password
    # Given I am on the login page- not using as we are already on login page
    When I enter username  as "username"
    And I enter password as "password"
    And click login button
    
    Then I should see products page with Title "<Title>"

    Examples: 
      | username | password | Title |
      | standard_user | secret_sauce | PRODUCTS |