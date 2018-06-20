@Regression @007
Feature: Regression 007 covering steps 13

  Background: 
    Given I open a browser at "NSI"
    And NSI HomePage submit continue to adviser centre
    And NSI HomePage I accept cookies
    And NSI Header click link by text "Contact"

  Scenario: Steps 13 Hero title on products page
    And CommonAction HeroTitle "Contact us" visible
    And CommonAction HeroTitle "If you are a financial adviser with a question for us, there are a few ways to get in touch." visible
    And CommonAction HeroTitle FontColour is "#502387"

  Scenario Outline: Steps 13 colour check of element
    And NSI Contact verify background colour of element "<ELEMENT>" is "<COLOUR>"

    Examples: 
      | ELEMENT     | COLOUR |
      | email us    | 006262 |
      | call us     | f68c11 |
      | tweet us    | 0078a1 |
      | write to us | 870065 |

  Scenario Outline: Steps 13 Top FAQs
    When CommonAction click link by text "<LINK>"
    And NSI FAQs verify drop down link text "<TEXT>"

    Examples: 
      | LINK                                                         | TEXT                                                    |
      | Are the winning Premium Bonds the ones bought most recently? | true to say that more Bonds have been bought since 2000 |
      | Can Premium Bonds be held in a SIPP or SSAS?                 | No.                                                     |

  
  Scenario: Steps 11 alignment of elements
    Then NSI Contact elements are aligned
