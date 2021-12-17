Feature: Post API Login

  Scenario: Login with Admin creds
    Given url 'http://localhost/fms/REST/login.php'
    And form field username = "sameer_r"
    And form field password = "Sameer@123"
    When method POST
    Then status 200
    And match response == {"Message":"Login Successful","First_Name":"Sameer","Last_Name":"Ramchandani","User Type":"ADMIN"}
    And print response
    And print responseStatus
    And print responseTime
    And print responseHeaders
    And print responseCookies
