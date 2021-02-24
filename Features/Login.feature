Feature: Nop Commerce Login

  Scenario: Successful login with valid credentials
    Given Launch chrome browser
    When Open nop commerce home page "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on Logout
    Then Page title should be "Your store. Login"
    And Close the browser

Scenario Outline: Login Data Driven
  Given Launch chrome browser
  When Open nop commerce home page "https://admin-demo.nopcommerce.com/login"
  And User enters email as "<email>" and password as "<password>"
  And Click on Login
  Then Page title should be "Dashboard / nopCommerce administration"
  When User click on Logout
  Then Page title should be "Your store. Login"
  And Close the browser
  Examples:
    | email | password |
    | admin@yourstore.com | admin |
    | admin1@yourstore.com | admin123 |

