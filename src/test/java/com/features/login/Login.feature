
Feature: Login Page

  @LoginValid
  Scenario Outline: user should be able to login with valid credentials
    Given user is on index page as "<Url>"
    When user clicks on LoginOrRegister button
    And user enters login Name as "<loginName>" and password as "<password>" and clicks on Login button
    Then user should be presented with the following validation message as "<loginValidationMessage>"
    And user clicks on edit profile button
    And user enters "firstName" "lastName" and EmailAddress telephone as "213-233-3340" and fax as "213-233-7770" in their respective box
    And user clicks on Continue button to confirms profile successful update message as "Success: Your account has been successfully updated."
    When user clicks on logoff button and logout Continue Button
    Then user is back to index page as "<Url>"

    Examples:
      | Url                              | loginName       | password    | loginValidationMessage |
      | https://automationteststore.com/ | datastudioplace | Manchester1 | Welcome back           |
