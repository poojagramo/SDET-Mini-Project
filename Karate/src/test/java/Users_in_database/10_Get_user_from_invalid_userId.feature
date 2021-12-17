Feature: GET users API

Scenario: Get users from invalid userId
Given url 'http://localhost/fms/REST/viewUsers.php'
And form field q = 'Nilesh'
When method GET
Then status 200
And print response