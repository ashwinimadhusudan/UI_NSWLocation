@nswsearch
Feature: Apply for a Number Plate in your preferred RTA in NSW

  Scenario Outline: Navigate to the RTA website, search for "Apply for a number plate" and search for preferred Suburb
    Given I navigate to the <url>
    When I search for <searchString>
    And I am in the searched page
    And I click on locate us Button
    And I land on Find a Service NSW Location Page
    And I enter the suburb as <suburb>
    Then I should see the Available service center as <serviceCenter>
    Examples:
      | url                             | searchString             | suburb                     | serviceCenter               |
      | https://www.service.nsw.gov.au/ | Apply for a number plate | Sydney 2000                | Marrickville Service Centre |
      | https://www.service.nsw.gov.au/ | Apply for a number plate |Sydney Domestic Airport 2020| Rockdale Service Centre     |