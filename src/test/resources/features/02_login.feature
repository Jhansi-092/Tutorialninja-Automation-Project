Feature: Login Module

Scenario: Login with valid credentials

Given user opens login page
When user enters valid login credentials
And clicks login button
Then user should login successfully

Scenario: Login with invalid credentials

Given user opens login page
When user enters invalid login credentials
And clicks login button
Then warning message for invalid login should display

Scenario: Verify forgot password functionality

Given user opens forgot password page
When user enters registered email
And clicks continue for password reset
Then password reset confirmation should display

Scenario: Verify logout functionality

Given user logs into application
When user clicks logout
Then logout should be successful