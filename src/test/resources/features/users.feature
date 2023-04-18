@User
  Feature: Filling of user details

  @positive
  Scenario: User try to login to Users Page and fill the following details
    When User enters username and password
      | positive_test_case_01 |
    And User clicks on Login button
    Then User should navigate to Users Page
      | user_credentials |
