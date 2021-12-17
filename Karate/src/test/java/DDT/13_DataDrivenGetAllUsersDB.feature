Feature: GET user API

  Background: 
    * def Users = read("responseUsers.json")

  Scenario: Get all users using GET method DDT Assertion
    Given url 'http://localhost/fms/REST/viewUsers.php'
    When method GET
    Then status 200
    And match response ==  Users
    And print response
