Feature: New user registration

  Scenario: Creation of new user account
    Given New account page is opened
    When user fill necessary fields and click Create account button
    Then new account is created

