Feature: Delete post

  Scenario: Verify user can delete post
    Given url host
    And path "/api/posts/5"
    When method delete
    Then status 204
    And print response