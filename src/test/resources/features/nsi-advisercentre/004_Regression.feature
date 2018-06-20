@Regression @004
Feature: Regression 004 covering steps 7

  Background: 
    Given I open a browser at "NSI"
    And NSI HomePage submit continue to adviser centre
    And NSI HomePage I accept cookies
    And NSI Header click link by text "Resources"

  Scenario: Steps 7 Hero title on products page
    And CommonAction HeroTitle "Resources" visible
    And CommonAction HeroTitle "Here you can find our forms, literature and useful information." visible
    And CommonAction HeroTitle FontColour is "#008c8c"

  Scenario Outline: Steps 7 Verify useful infomration and tool links
    And NSI Resources verify Useful Information section visible
    And CommonAction click link by text "<LINK>"
    Then CommonAction fullURL contains "<URL>"

    Examples: 
      | LINK                                         | URL                          |
      | Obtaining client information                 | obtaining-client-information |
      | Investing on behalf of a client              | investing-behalf-client      |
      | What to do when a client dies                | what-do-when-client-dies     |
      | Assisting overseas clients                   | assisting-overseas-clients   |
      | Tracing lost savings                         | tracing-lost-savings         |
      | Trusts                                       | trusts                       |
      | SIPPs and SSASs                              | sipps-and-ssass              |
      | Powers of Attorney                           | powers-attorney              |
      | Premium Bonds prize checker                  | nsandi.com/prize-checker     |
      | Index-linked Savings Certificates calculator | nsandi.com/ilsc-calculator   |

  Scenario Outline: Step 7 Verify forms and literature using Alphabetical
    When NSI Resources submit "Alphabetical" display option
    And NSI Resources submit "<TAB>" display tab
    Then NSI Resources verify "<NUMBER>" of items are displayed
    Then CommonAction click link by text "Load more"
    And NSI Resources verify "<REVISED NUMBER>" of items are displayed

    Examples: 
      | TAB        | NUMBER | REVISED NUMBER |
      | Forms      |      4 |              8 |
      | All        |      4 |              8 |
      | Literature |      4 |              8 |

  Scenario Outline: Step 7 Verify forms and literature using AtoZ
    When NSI Resources submit "Most Popular" display option
    And NSI Resources submit "<TAB>" display tab
    Then NSI Resources verify "<NUMBER>" of items are displayed

    Examples: 
      | TAB        | NUMBER |
      | Forms      |      4 |
      | All        |      4 |
      | Literature |      4 |

  Scenario: Step 7 Verifying the Search functionality
    And NSI Resources submit search text "Premium Bonds"
    And NSI Resources select "Premium Bonds" from search drop down
    And NSI Resources submit "Alphabetical" display option
    Then NSI Resources verify "4" of items are displayed
