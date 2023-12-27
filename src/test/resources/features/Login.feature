Feature: Login tests

  Scenario: Login Success
    Given I open the browser
    And I open Login page

    When I fill in email field and password field with valid credentials and click submit button
    Then I am logged in
