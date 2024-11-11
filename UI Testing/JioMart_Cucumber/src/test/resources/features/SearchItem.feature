Feature: Search for an item

  Scenario Outline: Verify user finds the searched item
    Given user open website
    Then verify user is on home page
    When user search for an "<item>"
    Then verify user is on products page
    Then verify user get the same "<item>" in search

    Examples:
    | item       |
    | sugar      |
    | milk       |
    | toothpaste |