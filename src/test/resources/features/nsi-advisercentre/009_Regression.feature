@Regression @009
Feature: Regression 009 covering steps 26 27

  Background: 
    Given I open a browser at "NSI"
    And NSI HomePage submit continue to adviser centre
    And NSI HomePage I accept cookies

  Scenario: Steps 26 27 Key Products
    And CommonAction click link by text "View more products"
    Then CommonAction fullURL contains "products"

  Scenario: Steps 26 27 alignment of Key products
    And NSI HomePage KeyProducts scroll to
    And NSI HomePage KeyProducts are aligned

  Scenario: Steps 26 27 colour of Key products
    And NSI HomePage KeyProducts scroll to
    And NSI HomePage KeyProduct verify colour of item one "fab914" item two "f06e0f" item three "00a0d7"

  Scenario Outline: Steps 26 27 Key Product text check
    And NSI HomePage KeyProducts scroll to
    Then NSI HomePage KeyProduct "<PRODUCT>" contains text "<TEXT>"

    Examples: 
      | PRODUCT | TEXT          |
      | One     | Permium Bonds |
      | Two     | Income Bonds  |
      | Three   | Direct ISA    |

  Scenario Outline: Steps 26 27 Checking Radio Option two on Key Products
    And NSI HomePage KeyProducts scroll to
    When NSI HomePage KeyProduct submit radio option two
    Then NSI HomePage KeyProduct "<PRODUCT NUMBER>" contains text "<TEXT>"

    Examples: 
      | PRODUCT NUMBER | TEXT     |
      | One            | Minimum  |
      | Two            | Maximum  |
      | Three          | variable |

  Scenario Outline: Steps 26 27 clicking link of product takes you to product page
    And NSI HomePage KeyProducts scroll to
    Then NSI HomePage KeyProduct clicking product "<PRODUCT NUMBER>"
    Then CommonAction fullURL contains "<URL>"

    Examples: 
      | PRODUCT NUMBER | URL                     |
      | One            | premium-bonds           |
      | Two            | guaranteed-growth-bonds |
      | Three          | guaranteed-income-bonds |
