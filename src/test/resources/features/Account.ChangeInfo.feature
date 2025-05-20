Feature: User contact information management

  Background:
    Given Login page is opened
    And user is logged in with email "pavlusenko.de.t@gmail.com" and password "123123Aa"


  @RevertNameAfterTest
  Scenario: User changes contact information
    Given My Account page is opened
    When user change First name and Last name on My Account page
    Then Notification that user changed account information is shown
    And User's First and Last names are changed


