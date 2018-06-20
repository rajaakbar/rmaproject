@Regression @010
Feature: Regression 010 covering steps 28 29

  Background: 
    Given I open a browser at "NSI"
    And NSI HomePage submit continue to adviser centre
    And NSI HomePage I accept cookies

  Scenario Outline: Steps 28 29 clicking link of promo panel take you to product page
    Then NSI HomePage PromoPanel clicking product "<PRODUCT NUMBER>"
    Then CommonAction fullURL contains "<URL>"

    Examples: 
      | PRODUCT NUMBER | URL             |
      | One            | prize-checker   |
      | Two            | ilsc-calculator |

  Scenario: Steps 28 29 promo panel are aligned
    And NSI HomePage KeyProducts scroll to
    And NSI HomePage PromoPanel is aligned

  Scenario: Steps 28 29 colour of Key products
    And NSI HomePage KeyProducts scroll to
    And NSI HomePage PromoPanel verify colour of item one "fab914" item two "008c8c"
