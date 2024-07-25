
@tag
Feature: User Books Flight
  I want to use this template to check User Booking Flight Ticket

  @tag1
  Scenario: Check Booking Flight Ticket
    Given I open browser with url "http://flights.qedgetech.com"
    Then I should see Login Page
    When I enter EmailID as UserID "bottahemanthkumar@gmail.com"
    And I enter User Password "demo"
    And I click Sign In
    Then I should see User Dashboard displayed
    When I select Date of Flight "21-June-2025"
    And I select Fly From 
    And I select Fly To
    And I select Search Flights
    Then Flights Search Results popup table display
    And I select by Flight Name "Air India"
    And I enter the Traveller Name "Hemanth kumar Botta"
    And I enter the number of Tickets "2"
    And I select Insert Order 
    And I created the order of booking of flight ticket
    When I click Logout
    Then I should see Login Page 
		When I close browser
  
