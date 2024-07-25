
@tag
Feature: New User Registeration
  I want to use this template to check New User Registeration

  @tag1
  Scenario: Check New User Registration
    Given I open browser with url "http://flights.qedgetech.com"
    Then I should see Login Page
    When I click Register link in Login Page
    And I enter Name as "Hemanth Kumar B"
    And I enter Contact as "7661960443"
    And I enter Email ID as "bottahemanthkumar@gmail.com"
    And I enter Password as "demo"
    And I Select Gender
    And I select Date of Birth as "09-03-1998"
    When I click Register button
    Then I should see Login Page
    When I close browser
    

  	
