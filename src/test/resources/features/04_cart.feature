Feature: Cart functionality

Scenario: Add product to cart

Given user logs into application for cart
When user searches product for cart
And user opens cart product
And user adds product to cart
Then product should appear in cart


Scenario: Update quantity in cart

Given user logs into application for cart
When user searches product for cart
And user opens cart product
And user adds product to cart
And user updates cart quantity
Then cart quantity should be updated


Scenario: Remove item from cart

Given user logs into application for cart
When user searches product for cart
And user opens cart product
And user adds product to cart
And user removes product from cart
Then cart should be empty


Scenario: Verify cart total

Given user logs into application for cart
When user searches product for cart
And user opens cart product
And user adds product to cart
And user updates cart quantity
Then cart total should display correctly