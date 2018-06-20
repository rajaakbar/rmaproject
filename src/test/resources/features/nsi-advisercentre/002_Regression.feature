@Regression @002
Feature: Regression 002 covering steps 3

  Background: 
    Given I open a browser at "NSI"
    And NSI HomePage submit continue to adviser centre
    And NSI HomePage I accept cookies
    And NSI Header click link by text "Why NS&I"

  Scenario: Steps 3 Hero Header text and colour
    And CommonAction HeroTitle "Why NS&I" visible
    And CommonAction HeroTitle "The foundation of any financial plan" visible
    And CommonAction HeroTitle FontColour is "#73a500"

  Scenario Outline: Steps 3 Find out more links
    And WhyNSandI clicking find out more for "<FINDOUTMORE>"
    Then CommonAction fullURL contains "<URL>"

    Examples: 
      | FINDOUTMORE  | URL                        |
      | OurRole      | our-role-clients-portfolio |
      | Heritage     | heritage                   |
      | OurService   | our-services               |
      | OurCustomers | our-customers              |
      | Partnership  | partnerships               |
