Feature: Search Product

Scenario: Search existing product

Given user opens search page
When user searches for valid product
And clicks search button
Then product should display successfully

Scenario: Search invalid product

Given user opens search page
When user searches invalid product
And clicks search button
Then no product warning should display