@Regression @001
Feature: Regression 001 covering steps 1 2 4 6 8 10 12 14 15 16

  Background: 
    Given I open a browser at "NSI"
    And NSI HomePage submit continue to adviser centre
    And NSI HomePage I accept cookies

  Scenario Outline: Steps 1, 2, 4, 6, 8, 10, and 12
    And NSI Header click link by text "<LINK>"
    Then CommonAction fullURL contains "<URL>"

    Examples: 
      | LINK      | URL        |
      | Why NS&I  | why-nsandi |
      | Contact   | contact    |
      | FAQs      | faqs       |
      | News      | news       |
      | Resources | resources  |
      | Products  | products   |

  Scenario: Steps 14, 15
    And NSI Header submit search "Direct ISA"
    And DirectISA confirm tabs are displayed
    Then CommonAction fullURL contains "ifa-search"

  Scenario Outline: Steps 16
    And NSI Header select option "<OPTION>" on the slider
    And NSI Header click the link on the current slider
    And CommonAction fullURL contains "<URL>"

    Examples: 
      | OPTION | URL                                               |
      |      1 | nsi-launches-new-phone-service-financial-advisers |
      |      2 | products                                          |
      |      3 | our-role-clients-portfolio                        |
