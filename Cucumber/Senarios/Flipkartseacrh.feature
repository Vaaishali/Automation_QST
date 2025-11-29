#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Search , product

  Scenario: Verify the functionality of search
    Given Launch an chrome browser.
    And navigate to flipkart site.
    When search "Mobile" in search field.
    And submit the data.
    Then Validated mobile has been searched by checking page title
    And close chrome browser.

  Scenario: Verify the functionality of product
    Given Launch an chrome browser.
    And navigate to flipkart site.
    When search "Mobile" in search field.
    And submit the data.
    And click on first product.
    Then Validated add to cart button in product title.
    And close chrome browser.


