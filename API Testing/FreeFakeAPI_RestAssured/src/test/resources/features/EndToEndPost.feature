Feature: End to end post feature

  Scenario: Verify user can create, get, update and delete post
    Given user wants to call "/api/posts" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "create_post.json" with create post request pojo
    When user performs post call
    Then verify status code is 201
    And verify response body has field "slug" is "enemies-of-nowhere"
    And verify response schema is "create_post_response_schema.json"
    And store "id" into "post.id"
    Given user wants to call "/api/posts/5" end point
    And set header "Content-Type" to "application/json"
    When user performs get call
    Then verify status code is 200
    And verify response body has field "slug" is "enemies-of-nowhere"
    And verify response schema is "create_post_response_schema.json"
    Given user wants to call "/api/posts/@postId" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "update_post.json" with "id" value "post.id" in update post pojo
    When user performs put call
    Then verify status code is 201
    And verify response body has field "slug" is "enemies-of-everyone"
    And verify response schema is "create_post_response_schema.json"
    Given user wants to call "/api/posts/@postId" end point
    And set header "Content-Type" to "application/json"
    When user performs delete call
    Then verify status code is 429

