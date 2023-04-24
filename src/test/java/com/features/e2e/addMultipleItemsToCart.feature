Feature: Verifying e-commerce Search to Order item functionality

  @addMultipleItemsToCart
  Scenario: user should be able to place an order
    Given user is on landing Page as "https://automationteststore.com/"
    When user scroll down to the middle page to view items
    And user should be able to see displayed items
    And user adds items to the cart and verifies number of items in the cart
    And user clicks on ItemsCartIcon at the left top sub menu bar
    And user lands on checkout cart page


