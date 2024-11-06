Feature: Verify Daraz works properly

  @Release
  Scenario: Verify User and Can login
    Given Check the Login button
    Then Click on the Login button
    When Click on the Email Field
    And Enter Value For Login
    Then Click on the Password Field
    When Enter Password For Login
    Then Click on the Submit Button

  @Release
  Scenario: View With Category Field
    Given Check the Category field id showed
    When Click on the Category Device
    Then Check on the Category Device product show
    And Click on the Category Device product

  @Release
  Scenario: Search field Check
    Given Check the Search Field on the page
    When I Click on the Search Field
    Then I Enter value on the Search Field
    And I submit value on the Search Field
    Then Check The Product is Current For Search Value
    And Click On The product

  @Release
  Scenario: Check User Can Sing UP
    Given Check the Sing Up button
    Then Click on the Sing Up button
    When Check the Sing Up Number field
    Then Click on the Sing Up Number field
    And Enter Number on sing up input field
    When Check the Sing Up Full name field
    Then Click on the Sing Up Full name field
    And Enter Name on sing up Full name field
    When Check the Sing Up Password field
    Then Click on the Sing Up Password field
    And Enter Password on Sing Up Password field
    When Check the Sing Up Send Code Button
    Then Click on the Sing Up Send Code Button
    