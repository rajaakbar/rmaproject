@Regression @013
Feature: Regression 013 covering steps 36 37 42 43 44 45 46 47

  Background: 
    Given I open a browser at "NSI"
    And NSI HomePage submit continue to adviser centre
    And NSI HomePage I accept cookies

  Scenario Outline: Steps 36 37 42 43 44 45 46 47 clicking useful links
    When CommonAction click link by text "<TEXT>"
    Then CommonAction fullURL contains "<URL>"

    Examples: 
      | TEXT                      | URL                                                                                 |
      | NS&I main website         | https://www.nsandi.com/                                                             |
      | About NS&I                | corporate.com/about-nsi/                                                            |
      | Privacy information       | privacy-information                                                                 |
      | Cookies                   | cookies                                                                             |
      | Freedom of Information    | corporate.com/about-nsi/regulations-policies-and-procedures/freedom-of-information/ |
      | Site conditions and legal | site-conditions-and-legal                                                           |
      | Accessibility             | accessibility                                                                       |

  Scenario: Steps clicking useful link twitter
    When CommonAction click link by text "@nsandihelp"
    Then CommonAction fullURLTwitter is "https://twitter.com/nsandihelp"


