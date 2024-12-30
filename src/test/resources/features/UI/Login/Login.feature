Feature: Verify User Login page fields.

  Scenario: Verify  Login Page fields
    Given I should see the login logo
    Then I should click on login logo
    And I should see the email login options
    Then I should click on Email login options
    And I should see Username field on this page
    When I should Input my Username
    And I should Input my My Password
    Then I should Click on Login Button
  
  Scenario: Verify Mobile Category views
    Given I should see the Mobile category
    Then I should Click on Mobile Category
    And I should See Mobile product

  Scenario: Verify Electronics Category views
    Given I should see the Electronics category
    Then I should Click on Electronics Category
    And I should See Electronics product
  
  Scenario: Verify Vehicles Category views
    Given I should see the Vehicles category
    Then I should Click on Vehicles Category
    And I should See Vehicles product

  Scenario: Verify Property Category views
    Given I should see the Property category
    Then I should Click on Property Category
    And I should See Property product

  