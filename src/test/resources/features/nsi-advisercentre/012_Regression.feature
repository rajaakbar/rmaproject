@Regression @012
Feature: Regression 012 covering steps 35

  Background: 
    Given I open a browser at "NSI"
    And NSI HomePage submit continue to adviser centre
    And NSI HomePage I accept cookies

  Scenario: Steps 35 subscribe to news letter error message checking
    When NSI Footer NewsUpdates submit subscribe button
    Then NSI Footer NewsUpdates error messages displayed as "This field is required"

  Scenario: Steps 35 subscribe to news letter colour check
    When NSI Footer NewsUpdates colour check

 
  Scenario: Steps 35 subscribe to news letter alignment check
    When NSI Footer NewsUpdates alignment check
