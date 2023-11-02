@regression
Feature: Check login functionality in application

	@smoke
  Scenario Outline: Validate if authorised user can login into application
    Given open browser
    And go to application url
    When add <username> and <password>
    And click on login
    Then user navigates

    Examples: 
      | username        | password |
      | user1@gmail.com | pass1    |
      | user2@gmail.com | pass2    |
