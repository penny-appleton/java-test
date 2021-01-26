

Feature: Checkout Discounts Active
  I want the total price to be calculated with the appropriate discount applied when I checkout with my groceries 

	Background: setup store with all discounts active
	  Given All discounts are currently active
  	
  Scenario:  3 soups with 2 bread give a 50% discount on 1 loaf of bread
    Given I have 3 soup
    And I have 2 bread
    When I choose to checkout
    Then The total cost should be $3.15

	Scenario: 6 Apples with 1 milk should apply 10% discount on apples
  	Given I have 6 apple
    And I have 1 milk
    When I choose to checkout
    Then The total cost should be $1.84

    
  Scenario:  3 apples, 2 tins of soup and a loaf of bread
  	Given I have 3 apple
  	And I have 2 soup
  	And I have 1 bread
  	When I choose to checkout
  	Then The total cost should be $1.97