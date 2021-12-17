Feature: GET students API

Scenario: View specific student
Given url 'http://localhost/fms/REST/viewStudent.php'
And form field q = '1'

When method GET
Then status 200
And print response