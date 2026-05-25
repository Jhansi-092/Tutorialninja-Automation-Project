Feature: Checkout Functionality

Scenario: Proceed to checkout
Given user logs into application for checkout
When user searches product for checkout
And user opens checkout product
And user adds product to cart for checkout
And user proceeds to checkout
Then checkout page should open

Scenario: Enter billing details during checkout

Given user logs into application for checkout
When user searches product for checkout
And user opens checkout product
And user adds product to cart for checkout
And user proceeds to checkout
And user enters billing details
Then billing details should save successfully

Scenario: Select payment method
Given user logs into application for checkout
When user searches product for checkout
And user opens checkout product
And user adds product to cart for checkout
And user proceeds to checkout
And user enters billing details
And user selects payment method
Then payment method should be selected successfully
Scenario: Confirm order successfully

Given user logs into application for checkout
When user searches product for checkout
And user opens checkout product
And user adds product to cart for checkout
And user proceeds to checkout
And user enters billing details
And user selects payment method
And user confirms order
Then order should be placed successfully



