Feature: GET users API

Scenario: Get all the users in the database
Given url 'http://localhost/fms/REST/viewUsers.php'

When method GET
Then status 200
And print response