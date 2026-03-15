Feature: Tracking search

  Scenario Outline: Search tracking id
    Given user is on home page
    When user enters trackingId <index> and submit
    Then user see search results
    And tracking id is visible and correct <index>

    Examples:
      | index |
      | 0 |
      | 1 |
      | 2 |
      | 3 |
      | 4 |