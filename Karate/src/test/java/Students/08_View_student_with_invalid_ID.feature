Feature: GET students API

Scenario: View student with invalid ID
Given url 'http://localhost/fms/REST/viewStudent.php'
And form field q = '123'

When method GET
Then status 404
And print response