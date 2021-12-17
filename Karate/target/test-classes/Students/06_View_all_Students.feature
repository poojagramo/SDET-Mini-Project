Feature: GET students API

  Background: 
    * url  'http://localhost/fms/REST'

  # Simple GET Request
  Scenario: View all students
    Given url 'http://localhost/fms/REST/viewStudent.php'
    When method GET
    Then status 200
    And print response

  #Request with Background
  Scenario: View all students (using background)
    Given path '/viewStudent.php'
    When method GET
    Then status 200
    And print response
