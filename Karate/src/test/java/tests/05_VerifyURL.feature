Feature: Verify URL Fee Management System

  Scenario: Test GET API
    Given url 'http://localhost/fms'
    When method GET
    Then status 200
