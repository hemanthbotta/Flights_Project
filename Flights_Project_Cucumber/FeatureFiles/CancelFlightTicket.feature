
@tag
Feature: User Cancel Ticket
  I want to use this template to Check Cancellation of Flight Ticket

  @tag1
  Scenario: Check Cancellation of Flight Ticket
    Given I open browser with url "http://flights.qedgetech.com"
    Then I should see Login Page
    When I enter EmailID as UserID "bottahemanthkumar@gmail.com"
    And I enter User Password "demo"
    And I click Sign In
    Then I should see User Dashboard displayed
    When I click on Flight Bookings
    And I should see the Orders Page
    And I capture the order ID "10627" and delete the ticket 
    Then I cancelled the ticket by deleting the order with Order ID
    When I click Logout
    Then I should see Login Page
    When I close browser


