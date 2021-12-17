Feature: POST API login

  Scenario: login with invalid creds
    Given url 'http://localhost/fms/REST/login.php'
    And form field username = 'anshuman_s'
    And form field password = ''
    When method POST
    Then status 200
    And print 'Response is:' , response
