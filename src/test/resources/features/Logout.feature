Feature: User's logging out

  Scenario: User logs out
    Given Login page is opened
    And user is logged in with email "pavlusenko.de.t@gmail.com" and password "123123Aa"
    When user logs out
    Then user is logged out

