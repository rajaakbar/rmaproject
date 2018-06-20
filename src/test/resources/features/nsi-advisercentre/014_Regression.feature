@Regression @014 
Feature: Regression 014 covering steps 40 48

  Background: 
    Given I open a browser at "NSI"
    And NSI HomePage submit continue to adviser centre
    And NSI HomePage I accept cookies

  Scenario Outline: Steps 40 useful links Share this page section
    And NSI HomePage ShareThisPage "<ICON>" icon visible

    Examples: 
      | ICON     |
      | facebook |
      | twitter  |
      | print    |
      | email    |

  Scenario: Steps 40 useful links Share this page section more option
    And NSI HomePage ShareThisPage click "more" icon
    And NSI HomePage ShareThisPage Find a service visible

  Scenario: Steps 48 monocrome
    And NSI HomePage KeyProduct verify colour of item one "fab914" item two "f06e0f" item three "00a0d7"
    When CommonAction click link by text "Monochrome theme"
    Then NSI HomePage KeyProduct verify colour of item one "000000" item two "000000" item three "000000"
