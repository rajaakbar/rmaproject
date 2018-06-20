@Regression @006
Feature: Regression 006 covering steps 11

  Background: 
    Given I open a browser at "NSI"
    And NSI HomePage submit continue to adviser centre
    And NSI HomePage I accept cookies
    And NSI Header click link by text "FAQs"

  Scenario: Steps 11 Hero title on products page
    And CommonAction HeroTitle "Frequently asked questions" visible
    And CommonAction HeroTitle "In this section you" visible
    And CommonAction HeroTitle "ll find the answers to the most frequent questions asked by advisers about NS&I" visible
    And CommonAction HeroTitle FontColour is "#f06e0f"

  Scenario: Steps 11 search functionaliy
    And NSI FAQs submit search text with ""
    And NSI FAQs submit the drop down search with "General"
    And NSI FAQs submit "Alphabetical" display option
    And NSI FAQs verify "5" items are displayed
    And NSI FAQs submit Load more button
    And NSI FAQs verify "10" items are displayed

  Scenario: Steps 11 search functionaliy specific text
    And NSI FAQs submit search text with "What is the role of NS&I?"
    And NSI FAQs submit the drop down search with "General"
    And NSI FAQs submit "Alphabetical" display option
    And NSI FAQs verify "5" items are displayed
    And CommonAction click link by text "What is the role of NS&I?"
    And NSI FAQs verify drop down link text "As an Executive Agency of the Chancellor of the Exchequer"

  Scenario: Steps 11 alignment of elements
    Then NSI FAQs searchField and faqFilterType are aligned
    And NSI FAQs alphabeticalFilterBtb and mostPopularFilterBtn are aligned
