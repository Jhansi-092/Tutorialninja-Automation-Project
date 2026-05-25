Feature: Wishlist Module

Scenario: Add product to wishlist

Given user logs into application for wishlist
When user searches product for wishlist
And user opens searched product
And user adds product to wishlist
Then product should appear in wishlist

Scenario: Remove product from wishlist

Given user logs into application for wishlist
When user searches product for wishlist
And user opens searched product
And user adds product to wishlist
And user opens wishlist page
And user removes product from wishlist
Then wishlist should be empty

Scenario: Verify wishlist page

Given user logs into application for wishlist
When user opens wishlist page
Then wishlist page should display

Scenario: Update quantity in cart

Given user logs into application for cart
When user searches product for cart
And user opens cart product
And user adds product to cart
And user updates cart quantity
Then cart quantity should be updated