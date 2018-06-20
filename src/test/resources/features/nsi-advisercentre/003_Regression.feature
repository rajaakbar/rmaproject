@Regression @003
Feature: Regression 003 covering steps 5

  Background: 
    Given I open a browser at "NSI"
    And NSI HomePage submit continue to adviser centre
    And NSI HomePage I accept cookies
    And NSI Header click link by text "Products"

  Scenario: Steps 5 Hero title on products page
    And CommonAction HeroTitle "Our products" visible
    And CommonAction HeroTitle "We offer a variety of savings and investments to suit different" visible
    And CommonAction HeroTitle "Use the links below to find out more about our range and print our Quick Guide." visible
    And CommonAction HeroTitle FontColour is "#502387"

  Scenario Outline: Steps 5 Products currently on sale
    And NSI Products submit grid or list "grid"
    And NSI Products verify grid product text and colour currently on sale "<POSITION>" "<PRODUCT>" "<COLOUR>" "<TEXT>"
    And NSI Products click the product link in grid product position "<POSITION>"
    Then CommonAction fullURL contains "<URL>"

    Examples: 
      | POSITION | PRODUCT                 | COLOUR | TEXT                                                           | URL                     |
      |        1 | Premium Bonds           | fab914 | Bonds Premium Bonds offer your clients a                       | premium-bonds           |
      |        2 | Guaranteed Income Bonds | 00a0d7 | Guaranteed Income Bonds Give your clients a                    | guaranteed-income-bonds |
      |        3 | Guaranteed Growth Bonds | f06e0f | Guaranteed Growth Bonds Guaranteed Growth Bonds are designed   | guaranteed-growth-bonds |
      |        4 | Direct ISA              | 00a0d7 | ISA The NS&I Direct ISA offers your clients                    | direct-isa              |
      |        5 | Junior ISA              | 73a500 | ISA The NS&I Junior ISA offers your clients to invest tax-free | junior-isa              |
      |        6 | Direct Saver            | 008c8c | Saver The Direct Saver account offers a variable interest rate | direct-saver            |
      |        7 | Income Bonds            | f06e0f | Bonds Income Bonds provide a monthly income at a variable      | income-bonds            |
      |        8 | Investment Account      | 502387 | Account The Investment Account offers a variable interest      | investment-account      |

  Scenario Outline: Steps 5 Products no longer on sale
    And NSI Products submit grid or list "grid"
    And NSI Products submit "No Longer on sale" drop down
    And NSI Products verify product text and colour no longer on sale "<POSITION>" "<PRODUCT>" "<COLOUR>" "<TEXT>"
    And NSI Products click the product link within no longer on sale at position "<POSITION>"
    Then CommonAction fullURL contains "<URL>"

    Examples: 
      | POSITION | PRODUCT                            | COLOUR | TEXT                                             | URL                                |
      |        1 | 65+ Guaranteed Growth Bonds        | ffffff | With 65+ Guaranteed Growth Bonds, your clients   | 65-guaranteed-growth-bonds         |
      |        2 | Investment Guaranteed Growth Bonds | ffffff | Fixed rate Bond. Guaranteed return after 3 years | investment-guaranteed-growth-bonds |
      |        3 | Children's Bonds                   | ffffff | By choosing Children’s Bonds, your client can    | childrens-bonds                    |

  Scenario Outline: Steps 5 Products not currently on sale
    And NSI Products submit grid or list "grid"
    And NSI Products submit "Not currently on sale" drop down
    And NSI Products verify product text and colour not currently on sale "<POSITION>" "<PRODUCT>" "<COLOUR>" "<TEXT>"
    And NSI Products click the product link within not currently on sale at position "<POSITION>"
    Then CommonAction fullURL contains "<URL>"

    Examples: 
      | POSITION | PRODUCT                             | COLOUR | TEXT                                               | URL                                 |
      |        1 | Index-linked Savings Certificates   | ffffff | With Index-linked Savings Certificates, you can    | index-linked-savings-certificates   |
      |        2 | Fixed Interest Savings Certificates | ffffff | Fixed Interest Savings Certificates Fixed Interest | fixed-interest-savings-certificates |

  Scenario Outline: DEFECT Step 5 Radio switch and text not overlapping
    And NSI Products submit grid or list "Grid"
    And NSI Products click radio option two for positions "<POSITION1>" "<POSITION2>" "<POSITION3>"
    And NSI Products verify product text for for radio option two "<POSITION1>" "<POSITION2>" "<POSITION3>" "<TEXT1>" "<TEXT2>" "<TEXT3>"
    Then NSI Products verify product text for radio option two horizontal alined "<POSITION1>" "<POSITION2>" "<POSITION3>"
    And NSI Products verify products text for radio option two is the same hight "<POSITION1>" "<POSITION2>" "<POSITION3>"

    Examples: 
      | POSITION1 | POSITION2 | POSITION3 | TEXT1   | TEXT2      | TEXT3      |
      |         1 |         2 |         3 | £50,000 | £1 million | £1 million |
      |         4 |         5 |         6 | £20,000 | £4,260     | £4 million |

  Scenario: Step 5 Alignment list or grid for Products on Sale
    Then NSI Products items are vertically alined
    And NSI Products submit grid or list "Grid"
    Then NSI Products items are horizontal alined
