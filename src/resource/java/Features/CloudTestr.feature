Feature: Validate the CloudTestr post build deployments

@Tag
Scenario: CT_TC_1 Loginto Application and Validate the page title
Given Lanuch the URL "https://global.cloudtestr.com/app/#/login"
When Enter the username "Divya.Kukkala@suneratech.com" and password "Welcome@4321"
And Click on login button
Then Successfully logged into CloudTestr and validate the page title

@Tag
Scenario: CT_TC_2 Verify the widgets displayed
Given Lanuch the URL "https://global.cloudtestr.com/app/#/login"
When Enter the username "Divya.Kukkala@suneratech.com" and password "Welcome@4321"
And Click on login button
Then Verify the number of widgets "6"

@Tag
Scenario: CT_TC_3 Apply the filter and validate the filter values
Given Lanuch the URL "https://global.cloudtestr.com/app/#/login"
When Enter the username "Divya.Kukkala@suneratech.com" and password "Welcome@4321"
And Click on login button
And Click on application dropdown from filter 
And Select the application as "SFDC" 
And Click on product dropdown from filter 
And Select the product as "Account"
And Click on search button
Then validate widget values should contains Accounts "Accounts"

@Tag
Scenario: CT_TC_4 Verify the menu items
Given Lanuch the URL "https://global.cloudtestr.com/app/#/login"
When Enter the username "Divya.Kukkala@suneratech.com" and password "Welcome@4321"
And Click on login button
Then Validate the menu items should be "9"
 
