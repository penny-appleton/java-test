

Feature: Checkout
  I want the total price to be calculated with the appropriate discount applied when I checkout with my groceries 


  Scenario: No discount available
    Given I have 1 soup
    And I have 2 bread
    When I choose to checkout 
    Then The total cost should be $2.25
    
  Scenario:  Apples get a 10% discount
  	Given I have 6 apple
  	When I choose to checkout
  	Then The total cost should be $.54
  	
  Scenario:  3 soups with 2 bread give a 50% discount on 1 loaf of bread
    Given I have 3 soup
    And I have 2 bread
    When I choose to checkout
    Then The total cost should be $3.15
    
  #Scenario: 6 Apples with 1 milk should discount apples 10%
  #	Given I have 6 apple
    #And I have 1 milk
    #When I choose to checkout
    #Then The total cost should be $1.90

 #Scenario: 6 Apples with 1 milk should discount apples 10%
  #	Given I have 6 apple
    #And I have 1 milk
    #When I choose to checkout
    #Then The total cost should be $1.90
    
