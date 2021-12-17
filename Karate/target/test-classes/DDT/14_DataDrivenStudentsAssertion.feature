Feature: GET user API

  Background: 
    * def Students = read("responseStudents.json")

  Scenario: Get all Students using GET method DDT Assertion
    Given url 'http://localhost/fms/REST/viewStudent.php'
    When method GET
    Then status 200 
    And match response ==  Students
    And print response
