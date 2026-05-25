Feature: Registration Module

Scenario: Register with valid details

Given user opens registration page
When user enters valid details
And clicks continue
Then registration should succeed


Scenario: Register with existing email

Given user opens registration page
When user enters existing email details
And clicks continue
Then warning message should display

Scenario: Verify mandatory field validation

Given user opens registration page
When user clicks continue without entering details
Then mandatory field warning should display

Scenario: Verify successful registration message

Given user opens registration page
When user enters valid details
And clicks continue
Then account creation message should display