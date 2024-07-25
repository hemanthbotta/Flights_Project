
@tag
Feature: User Login
  I want to use this template to check User Login Credentials

  @tag1
  Scenario: Check User Login wih Valid Data
    Given I open browser with url "http://flights.qedgetech.com"
    Then I should see Login Page
    When I enter EmailID as UserID "bottahemanthkumar@gmail.com"
    And I enter User Password "demo"
    And I click Sign In
    Then I should see User Dashboard displayed
    When I click Logout
    Then I should see Login Page
    When I close browser

  @tag2
  Scenario Outline: Check User Login with InValid Data
    Given I open browser with url "http://flights.qedgetech.com"
    Then I should see Login Page
    When I enter userid as "<userid>"
  	And I enter password as "<password>"
  	And I click Sign In
  	Then I should see error message
  	When I close browser

    Examples: 
      |userid|password|
			|bottahemanthkumar@gmail.com|xyz|
			|xyz@gmail.com|demo|
			|abc@gmail.com|xyz|
			|||
