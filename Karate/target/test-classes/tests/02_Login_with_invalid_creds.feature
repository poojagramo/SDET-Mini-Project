Feature: POST API login

  Scenario: login with invalid creds
    Given url 'http://localhost/fms/REST/login.php'
    And form field username = 'sameer_r'
    And form field password = 'chandan'
    When method POST
    Then status 401
    And print 'Response is:' , response
    And match response contains {"message":"Invalid username or Password"}
