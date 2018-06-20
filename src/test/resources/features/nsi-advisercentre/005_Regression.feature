@Regression @005
Feature: Regression 005 covering steps 9 17 18 19

  Background: 
    Given I open a browser at "NSI"
    And NSI HomePage submit continue to adviser centre
    And NSI HomePage I accept cookies
    And NSI Header click link by text "News"

  Scenario: Steps 9 Hero title on products page
    And CommonAction HeroTitle "News" visible
    And CommonAction HeroTitle "Catch up on the latest NS&I and HM Treasury news" visible
    And CommonAction HeroTitle FontColour is "#b40087"

  Scenario Outline: Steps 17 18 19  Clicking Link under each section
    And CommonAction click link by text "<ARTICAL>"
    Then CommonAction fullURL contains "<URL>"

    Examples: 
      | ARTICAL                                                                                                            | URL                                                                                                                             |
      | NS&I reduces interest rate for new customers purchasing 3-year Guaranteed Growth Bonds and Guaranteed Income Bonds | nsi-reduces-interest-rate-new-customers-purchasing-3-year-guaranteed-growth-bonds-and-guaranteed |
      | Autumn Budget 2017                                                                                                 | autumn-budget-2017                                                                               |
      | NS&I survey shows confidence in advice industry at all time high                                                   | nsi-survey-shows-confidence-advice-industry-all-time-high                                        |
