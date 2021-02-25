Feature: Customers

  Scenario: Add New Customer
    Given Launch chrome browser
    When Open nop commerce home page "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then User can view dashboard
    When User click on Customers menu
    And Click on Customers Menu Item
    And Click on Add New button
    Then User can view Add New Customer Page
    When User enter Customer Info
    And Click on Save button
    Then User can view confirmation message "The new customer has been added successfully"
    And Close the browser