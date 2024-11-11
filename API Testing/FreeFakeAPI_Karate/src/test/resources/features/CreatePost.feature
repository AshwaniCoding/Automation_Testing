Feature: Create post

  Background:
    * def body = read("classpath://json//create_post.json")

  Scenario: Verify user can create new post
    Given url host
    And path "/api/posts"
    And header Content-Type = "application/json"
    And header Accept = "application/json"
    And request body
    When method post
    Then status 201
    And print response