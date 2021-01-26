Feature: Checkout Discounts Inctive
  I want the total price to be calculated with the appropriate discount applied when I checkout with my groceries 

	Background: setup store with all discounts active
	  Given All discounts are currently inactive

  Scenario: No discount available
    Given I have 1 soup
    And I have 2 bread
    When I choose to checkout 
    Then The total cost should be $2.25
    
  Scenario: 6 Apples with 1 milk should not discount apples 10% 
  	Given I have 6 apple
    And I have 1 milk
    When I choose to checkout
    Then The total cost should be $1.90

