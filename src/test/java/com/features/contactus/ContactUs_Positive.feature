Feature: Verification of Contactus functionality

  @contactus_Positive
  Scenario: user should be able to submit a message in contactus form
    Given user on contactus page as "https://automationteststore.com/index.php?rt=content/contact" and title as "Contact Us"
    And user confirms company contact details are displayed as "012345 6781199"
    When user enters first name as "John" email Address as "email@email.com" and inquiry as "My message body"
    And user clicks on the submit button
    Then user should get confirmation message as "Your enquiry has been successfully sent to the store owner!"
    And user confirms the current url as "https://automationteststore.com/index.php?rt=content/contact/success"
    When user clicks on Continue button on contact page
    Then user should be on home page title as "A place to practice your automation skills!"
    