Feature: Post API login

  Scenario: Login with manag creds
    Given url 'http://localhost/fms/REST/login.php'
    And form field username = 'pooja_g'
    And form field password = 'Pooja@123'
    When method POST
    Then status 200
    And print response
