Feature: Login tests

  Scenario: Login Success
    Given I open Login page
    When I fill in email field "demo@class.com" and password field "te$t$tudent" with valid credentials and click submit button
    Then I am logged in
