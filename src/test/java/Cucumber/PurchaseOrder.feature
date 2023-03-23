
@tag
Feature: Put an order.

 Background:
 Given I landed on Lets Shop page

  @tag2
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add the product <productname> to cart
    And checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." is displayed in the confirmationpage

    Examples: 
      | name                   | password       | productname  |
      | 78bikash.hyd@gmail.com | Hyderabad@2023 | zara coat 3  |
     
