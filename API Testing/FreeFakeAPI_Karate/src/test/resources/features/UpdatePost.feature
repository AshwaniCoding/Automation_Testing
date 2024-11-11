Feature: Update post

  Background:
    * def body = read("classpath://json//update_post.json")
    * def responseOfCreatePost = call read("classpath://features//CreatePost.feature")

  Scenario: Verify user can update post
    Given url host
    And path "/api/posts/" + responseOfCreatePost.response.id
    And header Content-Type = "application/json"
    And header Accept = "application/json"
    And request body
    When method put
    Then status 201
    And print response