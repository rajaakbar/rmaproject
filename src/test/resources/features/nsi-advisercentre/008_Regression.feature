@Regression @008
Feature: Regression 008 covering steps 20 23 24 25

  Background: 
    Given I open a browser at "NSI"
    And NSI HomePage submit continue to adviser centre
    And NSI HomePage I accept cookies

  Scenario: Steps 20 clicking more resources
    And CommonAction click link by text "More resources"
    Then CommonAction fullURL contains "resources"

  Scenario Outline: Steps 23 24 clicking more resources
    Then CommonAction Confirm PDF download with "<LINK>" file name

    Examples: 
      | LINK        |
      | Quick guide |

  Scenario: Steps 25 Current poll
    And NSI HomePage CurrentPoll is visible
