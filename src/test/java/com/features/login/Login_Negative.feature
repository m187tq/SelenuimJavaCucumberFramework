Feature: Login Page - User Unsuccessful Login attempts

  @NegativeLogin
  Scenario Outline: User should NOT be able to login with invalid credentials
    Given user is on index page as "<url>"
    When user clicks on LoginOrRegister button
    And user enters login Name as "<loginName>" and password as "<password>" and clicks on Login button
    Then User gets error message as "<loginValidationMessage>" and still on Home page title as "<pageTitle>"

    Examples:
      | url                             | loginName       | password      | loginValidationMessage                       | pageTitle     |
      | https://automationteststore.com | WrongLoginName  | Manchester1   | Error: Incorrect login or password provided. | Account Login |
      | https://automationteststore.com | datastudioplace | WrongPassword | Error: Incorrect login or password provided. | Account Login |
      | https://automationteststore.com | WrongLoginName  | WrongPassword | Error: Incorrect login or password provided. | Account Login |
      | https://automationteststore.com |                 |               | Error: Incorrect login or password provided. | Account Login |
      | https://automationteststore.com | datastudioplace |               | Error: Incorrect login or password provided. | Account Login |
      | https://automationteststore.com |                 | Manchester1   | Error: Incorrect login or password provided. | Account Login |