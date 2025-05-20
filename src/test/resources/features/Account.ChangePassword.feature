Feature: Password changing

  Background:
    Given Login page is opened
    And user is logged in with email "pavlusenko.de.cp@gmail.com" and password "123123Aa"

  @RevertPassAfterTest
  Scenario: User changes password
    Given My Account page is opened
    When user changes Password

    Then Notification that user changed account information is shown
    And user is on Login page



