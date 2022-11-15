Feature: Retail Order Page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'bsxy@tekschool.us' and password 'Test@11021'
    And User click on login button
    And User should be logged in into Account

  @Addcart
  Scenario: Verify User can add an item to cart
    And User change the category to 'Smart Home'
    And User search for an item 'kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And User click add to Cart button
    Then the cart icon quantity should change to '2'
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click Add a new address link for shipping address
    And User fill new address form with below information
      | country     | fullName     | phoneNumber | streetAddress | apt | city  | state | zipCode |
      | Afghanistan | Naveed Ahmad |  9168632496 | 243 Main st   |  22 | Kabul | Balkh |   22332 |
    And User click Add Your Address button
    And User click Add a credit card or Debit Card for Payment method
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard   | expirationMonth | expirationYear | securityCode |
      | 1234111112341411 | Naveed Ahmad |               8 |           2029 |          292 |
    And User click on Add your card button
    And User click on Place Your Order
    Then a message should be displayed ‘Order Placed, Thanks’

  @AddcartwithourCard
  Scenario: Verify User can place an order with Shipping address and payment Method on file
    And User change the category to 'Electronics'
    And User search for an item 'Xbox '
    And User click on Search icon
    And User click on item
    And User select quantity '5'
    And User click add to Cart button
    Then the cart icon quantity should change to '5'
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click on Place Your Order
    Then a message should be displayed ‘Order Placed, Thanks’

  @orderCancel
  Scenario: Verify User can cancel the order
    And User click on Orders section
    And User click on first order in list
    And User click on Cancel The Order button
    And User select the cancelation Reason 'Bought wrong item'
    And User click on Cancel Order button
    Then a cancelation message should be displayed ‘Your Order Has Been Cancelled’

  @ReturnOrder
  Scenario: Verify User can Return the order
    And User click on Orders section
    And User click on first order in list
    And User click on Return Items button
    And User select the Return Reason 'Item damaged'
    And User select the drop off service 'FedEx'
    And User click on Return Order button
    Then a cancelation message should be displayed ‘Return was successful’

  @reviewOrder
  Scenario: Verify User can write a review on order placed
    And User click on Orders section
    And User click on first order in list
    And User click on Review button
    And User write Review headline 'headline value' and 'review text'
    And User click Add your Review button
    Then a review message should be displayed 'Your review was added successfully'
