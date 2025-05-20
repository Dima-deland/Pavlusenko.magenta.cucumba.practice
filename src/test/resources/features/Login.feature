Feature: User Login

  Background:
    Given Login page is opened

  Scenario: Successful login with valid credentials
    When user logins with email "pavlusenko.de.t@gmail.com" and password "123123Aa"
    Then user is logged in

  Scenario Outline: Unsuccessful Login  <case>
    When user logins with email "<email>" and password "<password>"
    Then user is on Login page
    And "<error_message>" is shown

    Examples:
      |case                 | email                     | password  | error_message                                                                                               |
      |with invalid email   | invalid@email.com         | 123123Aa  | The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later. |
      |as unregistered user | unregistered@gmail.com    | 123123Aa  | The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later. |
      |with invalid password| pavlusenko.de.t@gmail.com | wrongPass | The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later. |

  Scenario Outline: Unsuccessful Login with <case>
    When user logins with email "<email>" and password "<password>"
    Then "<message>" that  "<field_name>" field is required or incorrect is shown
    And user is on Login page

    Examples:
      |case                               | email                     | password | message                                                      | field_name      |
      |empty 'Email' field                |                           | 123123Aa | This is required field                                       | Email           |
      |empty 'Password' field             | pavlusenko.de.t@gmail.com |          | This is required field                                       | Password        |
      |empty 'Email' and 'Password' fields|                           |          | This is required field                                       | Email, Password |
      |incorrect email format             | test                      | 123123Aa | Please enter a valid email address (Ex: johndoe@domain.com). | Email           |

