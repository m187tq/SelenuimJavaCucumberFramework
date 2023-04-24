Feature: Verification of Contactus functionality


  @contactusNegative
  Scenario: user should not be able to submit a message in contactus form with blank fields
    Given user on contactus page as "https://automationteststore.com/index.php?rt=content/contact" and title as "Contact Us"
    And user confirms company contact details are displayed as "012345 6781199"
    When user enters first name as " " email Address as " " and inquiry as " "
    And user clicks on the submit button
    Then user should get warning firstname confirmation message as "First name: is required field! Name must be between 3 and 32 characters!"
    Then user should get warning email confirmation message as "Email: is required field! E-Mail Address does not appear to be valid!"
    Then user should get warning inquiry confirmation message as "Enquiry: is required field! Enquiry must be between 10 and 3000 characters!"

  @contactusNegative
  Scenario: user should not be able to submit a message in contactus form with invalid email
    Given user on contactus page as "https://automationteststore.com/index.php?rt=content/contact" and title as "Contact Us"
    And user confirms company contact details are displayed as "012345 6781199"
    When user enters first name as "John" email Address as "email" and inquiry as "My message body"
    And user clicks on the submit button
    Then user should gets invalid email warning  message as "E-Mail Address does not appear to be valid!"


    