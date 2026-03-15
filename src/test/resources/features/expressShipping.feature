Feature: Express Shipping Tests
  Scenario Outline: Verify working callback form
    Given user is on home page
    When user navigate to express page
    Then user clicks callback button
    And user can fill callback form with <userIndex> user

    Examples:
      | userIndex |
      | 0         |
      | 1         |
      | 2         |