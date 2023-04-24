Feature: Verifying e-commerce Search to Order item functionality

  @addRemoveItemsToCart
  Scenario: user should be able to place an order
    Given user is on landing Page as "https://automationteststore.com/"
    When user scroll down to the middle page to view items
    And user should be able to see displayed items
    And user adds items to the cart and verifies number of items in the cart
    And user clicks on ItemsCartIcon at the left top sub menu bar
    And user lands on checkout cart page
    And user adds quantity of an item as "4" and update
    And user clicks remove icon to remove an item and update
    And user clicks on the Check out button
    And user log in as a returning customer
    And user click on checkout confirmation order button
    And user is presented with a purchase confirmation page
    Then user gets an order number and thank message with first name displayed
    And user order confirmation page is populate with print icon, item image total price and continue shipping button
    And user clicks on continue and logout button
    Then user is back to home page