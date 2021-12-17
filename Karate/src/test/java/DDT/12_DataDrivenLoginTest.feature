Feature: POST user API

  Background:
    * def expectedOutput = read("responseLogin.json")

  Scenario: DDT login response Assertion
    Given url 'http://localhost/fms/REST/login.php'
    And form field username = "sameer_r"
    And form field password = "Sameer@123"
    When method POST
    Then status 200
    And match response ==  expectedOutput
    And print response
