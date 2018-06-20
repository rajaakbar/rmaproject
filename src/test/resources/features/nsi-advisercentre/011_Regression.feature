@Regression @011
Feature: Regression 011 covering steps 30 31 32 33 34 35

  Background: 
    Given I open a browser at "NSI"
    And NSI HomePage submit continue to adviser centre
    And NSI HomePage I accept cookies

  Scenario Outline: Steps 30 31 32 33 34 35 clicking link in Proud to support
    When NSI HomePage SupportPanel click on logo position "<POSITION>"
    When CommonAction switch to window "<WINDOW>" and Verify "<URL>"

    Examples: 
      | POSITION | WINDOW                                    | URL                                                                                            |  |
      | One      | CISI Financial Services Professional Body | https://www.cisi.org/cisiweb2/cisi-website/homepages/cisi-financial-services-professional-body |  |
      | Two      | The Personal Finance Society              | http://www.thepfs.org/                                                                         |  |
      | Three    | Society of Later Life Advisers - SOLLA    | https://societyoflaterlifeadvisers.co.uk/                                                      |  |

  Scenario Outline: Steps 35 clicking link in Proud to support
    When NSI HomePage SupportPanel click on logo position "<POSITION>"
    When CommonAction switch to window "<WINDOW>" and Verify "<URL>"

    Examples: 
      | POSITION | WINDOW                                                                            | URL                            |  |
      | Four     | Panacea Adviser: empowering Financial Advisers, Paraplanners and Mortgage Brokers | http://www.panaceaadviser.com/ |  |
