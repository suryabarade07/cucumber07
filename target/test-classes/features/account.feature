Feature: Account page API

  Scenario: Get Account List
    Given i have baseurl for get reuest
    When i have end point for get url
    Then i need to check the status code


  Scenario: create new Account
    Given i have baseurl for post
    And i have playload for post
    When i have put endpont for post url
    Then i need to check status code
