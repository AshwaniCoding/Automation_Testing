Feature: Add to cart

  Scenario: Verify user can add to cart and remove item
    Given user open website
    Then verify user is on home page
    When user hover to electronics link and click on mobiles and tablets
    Then verify user is on products page
    When user click on first item
    Then verify user is on item page
    When user click on add to cart button
    Then verify cart quantity is "1"
    When user click on view button
    Then verify user is on cart page
    When user click on remove item button
    Then verify cart page displays "Your Cart is Empty!"