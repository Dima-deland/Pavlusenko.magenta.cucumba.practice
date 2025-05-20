Feature: Cart page updating

  Background:
    Given Product page is opened
    And user adds Product to Cart
    And Cart page is opened

  Scenario: User delete product from Cart
    When user delete product from Cart
    Then amount of products in cart equals 0
    And "You have no items in your shopping cart" text is displayed



