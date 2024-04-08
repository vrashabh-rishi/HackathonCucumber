Feature: Getting list of all upcoming new bikes which are under 4 lakh

  Scenario: Successfully printing Bikes under 4 lakh
    Given user navigates to ZigWheels page
    When user hovers to Newbikes toggle
    And user clicks on Upcoming bikes
    And chooses manufacturer as Honda
    Then All the upcomings bikes of Honda manufacturer are displayed
