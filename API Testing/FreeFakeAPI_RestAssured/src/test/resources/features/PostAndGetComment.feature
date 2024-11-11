Feature: End to end comment feature

  Scenario: Verify user can create, get, update and delete comment
    Given user wants to call "/api/comments" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "create_comment.json" with create comment request pojo
    When user performs post call
    Then verify status code is 201
    And verify response body has field "content" is "sample comment"
    And verify response schema is "create_comment_response_schema.json"
    And store "id" into "comment.id"
    Given user wants to call "/api/comments/5" end point
    And set header "Content-Type" to "application/json"
    When user performs get call
    Then verify status code is 200
    And verify response schema is "create_comment_response_schema.json"
