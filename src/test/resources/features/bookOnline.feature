Feature: Online Book

  Scenario Outline: Book Online Parcel
    Given user is on home page
    Then user clicks on book online option
    And user select destination country
    Then user wants to send with documents <documents>
    And user wants to fill details for parcel
    And user clicks add <numberOfParcels> new parcel

    Examples:
      | documents | numberOfParcels |
      | "true"    | 1               |
      | "false"   | 3               |