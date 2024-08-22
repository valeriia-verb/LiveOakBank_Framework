Feature: 'Open a New Personal Savings Account' form feature

  # User story:
  # As a user, I should be able to fill and submit "Open a New Personal Savings Account" form

  #AC: If the user skips any field the form should not be submitted

  #@wip
  Scenario: Verify "Open a New Personal Savings Account" form is not submitted if one field is missing
    Given the user is on the Open a New Personal Savings Account page
    And user closes the pop-up
    When the user enters random test data for the form missing a field
    And the user presses the 'Next' button
    Then the user should see missing field highlighted