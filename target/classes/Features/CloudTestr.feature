Feature: Validate the CloudTestr post build deployments

@Tag
Scenario: Loginto Application and Validate the page title
Given Lanuch the URL "https://global.cloudtestr.com/app/#/login"
When Enter the username "Divya.Kukkala@suneratech.com" and password "Welcome@4321"
And Click on login button
Then Successfully logged into CloudTestr and validate the page title

@Tag
Scenario: Verify the widgets displayed
Given Lanuch the URL "https://global.cloudtestr.com/app/#/login"
When Enter the username "Divya.Kukkala@suneratech.com" and password "Welcome@4321"
And Click on login button
Then Verify the number of widgets "6"

@Tag
Scenario: Apply the filter and validate the filter values
Given Lanuch the URL "https://global.cloudtestr.com/app/#/login"
When Enter the username "Divya.Kukkala@suneratech.com" and password "Welcome@4321"
And Click on login button
And Click on application dropdown from filter 
And Select the application as "SFDC" 
And Click on product dropdown from filter 
And Select the product as "Account"
And Click on search button
Then validate widget values should contains Accounts "Accounts"
 
