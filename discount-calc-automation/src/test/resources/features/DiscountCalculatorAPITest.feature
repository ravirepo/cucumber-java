Feature: Validation of Discount calculation

  @api
  Scenario: Validate Discount rules for NJ and PA
    Given I am a customer who is looking for a discount
    And My address is in "NJ"
    When I view my discount
    Then I expect a "10" percent discount

  @api
  Scenario Outline: Validate Discount rules
    Given I am a customer who is looking for a discount
    And My address is in "<State>"
    And My Profession is "<Profession>"
    When I view my discount
    Then I expect a "<Expected Discount>" percent discount

    Examples:
      | Scenario    | State | Senior Citizen | Profession | Expected Discount |
      | PA Resident | PA    | No             | NA         | 10                |
      | Developer   | CA    | No             | Developer  | 10                |

