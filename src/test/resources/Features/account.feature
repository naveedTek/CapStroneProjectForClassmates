
Feature: Retail Account Page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'naveed@Tek.us' and password 'Test@12345'
    And User click on login button
    And User should be logged in into Account
    When User click on Account option

  @Acount
  Scenario: Verify User can update Profile Information
    And User update Name 'tekpshxl' and Phone '9169490544'
    And User click on Update button
    Then user profile information should be updated

  @AcountPass
  Scenario: Verify User can Update password
    And User enter below information
      | previousPassword | newPassword | confirmPassword |
      | Test@11021       | Test@1102   | Test@1102       |
    And User click on Change Password button
   Then a message should Be displayed 'Password Updated Successfully'

  @Acountpayment @Acount
  Scenario: Verify User can add a payment method
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1111232213334403 | tekpshxl   |              10 |           2025 |          333 |
    And User click on Add your card button
    Then a message should be displayed‘Payment Method added sucessfully’

  @AcountpaymentUpdate @Acount
  Scenario: Verify User can edit Debit or Credit card
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 9993999992999099 | tek        |               9 |           2028 |          999 |
    And user click on Update Your Card button
    Then a message should be displayed ‘Payment Method updated Successfully’

  @Acountpaymentremove @Acount
  Scenario: Verify User can remove Debit or Credit card
    And User click on remove option of card section
    Then payment details should be removed

  @Address @Acount
  Scenario: Verify User can add an Address
    And User click on Add address option
    And user fill new address form with below information
      | country       | fullName | phoneNumber | streetAddress | apt | city     | state    | zipCode |
      | United States | Jhon     |  9168726596 | 230 Main St   |  54 | Stafford | Virginia |   22554 |
    And User click Add Your Address button
    Then a message should be displayed ‘Address Added Successfully’

  @AddressEdit @Acount
  Scenario: Verify User can edit an Address added on account
    And User click on edit address option
    And user fill new address form  with below information
      | country     | fullName | phoneNumber | streetAddress | apt | city  | state      | zipCode |
      | Afghanistan | naveed   |  9160944598 | 123 bob st    |  33 | Kabul | Badakhshan |   22334 |
    And User click update Your Address button
    Then a message should be displayed ‘Address Updated Successfully’

  @AddressRemoved @Acount
  Scenario: Verify User can remove Address from Account
    And User click on remove option of Address section
    Then Address details should be removed
