@smoke @login @qc
Feature: Verify login functionality

  Background:
    Given the user launches the website "https://admintest.gailgas-png.in/"

  Scenario: Successful login with valid credentials
    When the user enters a valid email id "apati@keypoint-tech.com"
    And the user enters a valid password "Pallavi@2"
    And the user enters the captcha manually
    And the user clicks on the login button
    And the user clicks on the force login button
    And the user enters a valid otp "123456"
    And the user re-enters the captcha
    And the user clicks on the verify button
