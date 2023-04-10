@services
Feature: Test Case scenario for Services Page

  @positive
  Scenario: User try to login to easy automation website by entering valid username and password
    When User enters username and password
      | positive_test_case_01 |
    And User clicks on Login button
    Then User should navigate to Services Page
