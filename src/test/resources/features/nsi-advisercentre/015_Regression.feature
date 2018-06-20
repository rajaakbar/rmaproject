@Regression @015 
Feature: Regression 015 covering steps 38

  Background: 

  Scenario: Steps 38 click Useful link for Media centre
    Given I open a browser at "NSI"
    And NSI HomePage submit continue to adviser centre
    And NSI HomePage I accept cookies
    When CommonAction click link by text "Media Centre"
    And CommonAction click link by text "Continue to NS&I Corporate pages and media centre"
    Then CommonAction fullURL contains "media-centre"
