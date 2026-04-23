Feature: Student Registration using Excel data

  Scenario: Submit student registration form using Excel
    Given the user opens the student registration form
    When the user fills the student registration form from Excel
    Then the form should be submitted successfully
