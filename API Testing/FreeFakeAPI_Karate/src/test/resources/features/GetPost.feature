Feature: Get post

  Scenario: Verify user can get post
    Given url host
    And path "/api/posts/4"
    And header Accept = "application/json"
    When method get
    Then status 200
    And print response