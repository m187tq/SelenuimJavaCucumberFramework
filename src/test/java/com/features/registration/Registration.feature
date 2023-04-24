Feature: Verification of Registration functionality

  @RegistrationFunctionality
  Scenario: user should be able to Register with valid credentials
    Given user is on index page
    When user clicks the LoginOrRegister link
    And user should be on account login page with option to login or create an Account
    And user verifies register account radio button is checked and clicks on Continue button
    And user is on account create page and verifies page heading as "CREATE ACCOUNT" and page Url contains "?rt=account/create"
    And user enters generated email and Your Personal Section Details
    And user enters Your Address Section Details
    And user enters generated loginName and Login Section Details
    And user subscribed to Newsletter and check on Yes
    And user ticks on Privacy Policy radio button and create account button
    Then user gets success confirmation message as "Your Account Has Been Created"
    And user clicks on Continue Shipping button
    And user is on home page and presented with welcome message as "Welcome back yourFirstName"
    And user clicks on SignOut button
    And user is back to login page