Feature: Login into Application
Scenario: Positive test validating login
Given Initialize the browser with chrome
And Navigate "http://www.qaclickacademy.com/" site
And Click on the Login link in home page to land on Secure sign in page
When User enters "test99@gmail.com" and "123456" and logs in
Then Verify that user is Succesfully logged in 
