

Feature: Checkout
  I want the total price to be calculated with the appropriate discount applied when I checkout with my groceries 


  Scenario: No discount available
    Given I have 1 tin of soup
    When I choose to checkout 
    Then The total cost should be $.65

