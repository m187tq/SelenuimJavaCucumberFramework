Feature: Verification of Registration functionality

  @register
  Scenario: user should be able to Register with valid credentials
    Given user is on index page url as "https://automationteststore.com/" and page title as "A place to practice your automation skills!"
    When user clicks on Login Or Register link
    And user verifies register account radio button is checked and clicks on Continue button
    And user is on account create page and verifies page-heading as "CREATE ACCOUNT" and page Url contains "?rt=account/create"
    And user is in personal details in "Your Personal Details"
    And user enters First Name box as FirstName
    And user enters Last Name box as LastName
    And user enters fresh email in EMail box
    And user enters Telephone box as 07400000000
    And user enters Fax box as 0740000000

    And user on Address Section as "Your Address"
    And user enters Company name as YourCompanyName
    And user enters Address One box as yourAddress1
    And user enters Address Two box as yourAddress2
    And user enters City box as yourCity
    And user selects Region or State as Lancashire
    And user enters ZIP Code box as "M11 IPT"
    And user enters Country box as "United Kingdom"

    And user on login section as "Login Details"
    And user enters loginName in Login name box
    And user enters password in Password box as "Password@123"
    And user enters Confirm password in Password Confirm box as "Password@123"

    And user subscribed to Newsletter by checking on Yes
    And user ticks on Privacy Policy radio button and create account button
    And user clicks on Continue button

    Then user gets success confirmation msg as "YOUR ACCOUNT HAS BEEN CREATED!"
    And user gets congratulatory msg as "Congratulations! Your new account has been successfully created!"
    And user clicks on ContinueAccountSuccess button

