Feature: Validate the CloudTestr post build deployments

@Smoke
Scenario: CT_TC_1 Loginto Application and Validate the page title
Given Lanuch the URL "https://global.cloudtestr.com/app/#/login"
When Enter the username "Divya.Kukkala@suneratech.com" and password "Welcome@4321"
And Click on login button
Then Successfully logged into CloudTestr and validate the page title

@Smoke
Scenario: CT_TC_2 Verify the widgets displayed
Given Lanuch the URL "https://global.cloudtestr.com/app/#/login"
When Enter the username "Divya.Kukkala@suneratech.com" and password "Welcome@4321"
And Click on login button
Then Verify the number of widgets "6"

@Smoke
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

@Smoke
Scenario: CT_TC_4 Verify the menu items
Given Lanuch the URL "https://global.cloudtestr.com/app/#/login"
When Enter the username "Divya.Kukkala@suneratech.com" and password "Welcome@4321"
And Click on login button
Then Validate the menu items should be "9"

@Smoke
Scenario: CT_TC_5 Verify the Test Cases Page have TCs
Given Lanuch the URL "https://global.cloudtestr.com/app/#/login"
When Enter the username "Divya.Kukkala@suneratech.com" and password "Welcome@4321"
And Click on login button
And Mouseover on design and expand design dropdown and click on test cases
Then Verify the page should have test cases atleast one

@Smoke
Scenario: CT_TC_6 Apply the filter in TC page and TC page should have atleast one TC
Given Lanuch the URL "https://global.cloudtestr.com/app/#/login"
When Enter the username "Divya.Kukkala@suneratech.com" and password "Welcome@4321"
And Click on login button
And Mouseover on design and expand design dropdown and click on test cases
And Click on application dropdown from filter 
And Select the application as "SFDC" 
And Click on product dropdown from filter 
And Select the product as "Account"
And Click on search button
Then Verify the page should have test cases atleast one
 
