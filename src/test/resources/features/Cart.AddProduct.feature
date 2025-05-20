Feature: Product Cart functionality

  Scenario: Add Product to Cart
    Given Product page is opened
    When user adds Product to Cart
    And Cart page is opened
    Then amount of products in cart equals 1
    And Cart counter number is changed to 1

