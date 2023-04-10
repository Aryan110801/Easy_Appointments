@login
Feature: Login Scenarios of Easy Appointments Website

 #LoginNegative1
  @negative
  Scenario: User will try to login with wrong username
    Given User is on home page of website
    When User enters username and password
      | negative_test_case_01 |
    And User clicks on Login button
    Then User gets alert message
      | Alert |

 #LoginNegative2
  @negative
  Scenario: User will try to login with wrong password
    When User enters username and password
      | negative_test_case_02 |
    And User clicks on Login button
    Then User gets alert message
      | Alert |

     #LoginNegative3
  @negative
  Scenario: User will try to login with wrong username and wrong password
    When User enters username and password
      | negative_test_case_03 |
    And User clicks on Login button
    Then User gets alert message
      | Alert |

    #LoginNegative4
  @negative
  Scenario: User try to login without entering username
    When User enters username and password
      | negative_test_case_04 |
    And User clicks on Login button
    Then User gets alert message
      | Invalid credentials |

    #LoginNegative5
  @negative
  Scenario: User try to login without entering password
    When User enters username and password
      | negative_test_case_05 |
    And User clicks on Login button
    Then User gets alert message
      | Invalid credentials |

    #LoginNegative6
  @negative
  Scenario: User try to login without entering username and password
    When User enters username and password
      | negative_test_case_06 |
    And User clicks on Login button
    Then User gets alert message
      | Invalid credentials |

        #LoginNegative7
  @negative
  Scenario: User try to login by entering password with capital alphabets
    When User enters username and password
      | negative_test_case_07 |
    And User clicks on Login button
    Then User gets alert message
      | Alert |

#LoginPositive1
  @positive
  Scenario: User try to login to easy automation website by entering valid username and password
    When User enters username and password
      | positive_test_case_01 |
    And User clicks on Login button
    Then User should successfully login