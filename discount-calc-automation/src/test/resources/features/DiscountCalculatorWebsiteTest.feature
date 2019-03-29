Feature: Verify Discount Website

  @web
  Scenario: Verify Discount Website
    Given I am a customer who is looking for a discount on the website
    And My address is in "NJ" on the website
    When I view my discount on the website
    Then I expect a "10" percent discount on the website