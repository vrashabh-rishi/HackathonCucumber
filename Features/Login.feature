Feature: Trying to login with google using invalid credentials

  Scenario Outline: Login Data Driven Excel
    Given the user navigates to home page
    When clicking on Login button And clicking on google
    Then entering the invalid email "<row_index>" 
    

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      