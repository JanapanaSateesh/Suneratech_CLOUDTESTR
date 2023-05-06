Feature: Validate the CloudTestr post build deployments

  Background: Login Background
    Given Lanuch the URL "https://global.cloudtestr.com/app/#/login"
    When Enter the username  and password
      | username                     | password     |
      | RGl2eWEuS3Vra2FsYUBzdW5lcmF0ZWNoLmNvbQ== | V2VsY29tZUA0MzIx |
    And Click on login button

  @Smoke
  Scenario: CT_TC_1 Loginto Application and Validate the page title
  Then Successfully logged into CloudTestr and validate the page title
  
  @Smoke
  Scenario: CT_TC_2 Verify the widgets displayed
  Then Verify the number of widgets "6"
  
  @Smoke
  Scenario: CT_TC_3 Apply the filter and validate the filter values
  And Click on application dropdown from filter
  And Select the application as "SFDC"
  And Click on product dropdown from filter
  And Select the product as "Account"
  And Click on search button
  Then validate widget values should contains Accounts "Accounts"
  
  @Smoke
  Scenario: CT_TC_4 Verify the menu items
  Then Validate the menu items should be "9"
  
  @Smoke
  Scenario: CT_TC_5 Verify the Test Cases Page have TCs
  And Mouseover on design and expand design dropdown and click on test cases
  Then Verify the page should have test cases atleast one
  
  @Smoke
  Scenario: CT_TC_6 Apply the filter in TC page and TC page should have atleast one TC
  And Mouseover on design and expand design dropdown and click on test cases
  And Click on application dropdown from filter
  And Select the application as "SFDC"
  And Click on product dropdown from filter
  And Select the product as "Account"
  And Click on search button
  Then Verify the page should have test cases atleast one
  
  
  @Smoke
  Scenario: CT_TC_7 Search for test case and validate the test case id
  And Mouseover on design and expand design dropdown and click on test cases
  And Search with the test case id "50966"
  And Click on search button
  And Verify the page should have test cases atleast one
  Then Validate the test case should contain the test case id in the above step
  
  @Smoke
  Scenario: CT_TC_8 Search for test case and validate Audit Log
  And Mouseover on design and expand design dropdown and click on test cases
  And Search with the test case id "50966"
  And Click on search button
  And Verify the page should have test cases atleast one
  And Validate the test case should contain the test case id in the above step
  And Click on test case
  And Click on audit log tab
  Then Validate audit log has data
  
  
  @Smoke
  Scenario: CT_TC_9 Search for test case and validate Documentation
  And Mouseover on design and expand design dropdown and click on test cases
  And Search with the test case id "50966"
  And Click on search button
  And Verify the page should have test cases atleast one
  And Validate the test case should contain the test case id in the above step
  And Click on test case
  Then Vefify documentation tab should have images
  
  @Smoke
  Scenario: CT_TC_10 Search for test case and validate Configuration lines
  And Mouseover on design and expand design dropdown and click on test cases
  And Search with the test case id "50966"
  And Click on search button
  And Verify the page should have test cases atleast one
  And Validate the test case should contain the test case id in the above step
  And Click on test case
  And Click on configuration tab
  Then Vefify configuration tab should have config lines
  
  
  @Smoke
  Scenario: CT_TC_11 Search for test case and validate Configuration lines
  And Mouseover on design and expand design dropdown and click on test cases
  And Search with the test case id "50966"
  And Click on search button
  And Verify the page should have test cases atleast one
  And Validate the test case should contain the test case id in the above step
  And Click on test case
  And Click on runhistory tab
  Then Vefify runhistory tab should have result files
  
  
  @Smoke
  Scenario: CT_TC_12 Verify the Test Set Page have TCs
  And Mouseover on design and expand design dropdown and click on test set
  Then Verify the page should have test set atleast one
  
  @Smoke
  Scenario: CT_TC_13 Search for test set and validate the test set id
  And Mouseover on design and expand design dropdown and click on test set
  And Search with the test set id "4859"
  And Click on search button
  And Verify the page should have test set atleast one
  Then Validate the test set should contain the test set id in the above step
  
  @Smoke
  Scenario: CT_TC_14 Search for test set and validate the test set id
  And Mouseover on design and expand design dropdown and click on test set
  And Search with the test set id "4859"
  And Click on search button
  And Click on test set
  And Click on audit log tab
  Then Validate audit log has data
  
  @Smoke
  Scenario: CT_TC_15 Search for test set and validate the test set id
  And Mouseover on design and expand design dropdown and click on test set
  And Search with the test set id "4859"
  And Click on search button
  And Click on test set
  Then Vefify test set runhistory tab should have result files
  
  @Smoke
  Scenario: CT_TC_16 Validate Integrations page title and REST tab has data
  And Mouseover on integrations
  And Click on Integrations
  And Validate integrations page title
  Then Click on Rest tab and rest tab should have the data
  
  @Smoke
  Scenario: CT_TC_17 validate the releases section has the created releases
  And Mouseover on integrations
  And Click on plan
  And Click on Releases
  Then Validate the releases have the releases data
  
  
  @Smoke
  Scenario: CT_TC_18 search for the release and one release should display after search
  And Mouseover on integrations
  And Click on plan
  And Click on Releases
  And Search for the release name "Unmonitored_Scripts_12"
  And Click on search button
  Then Validate only one release should display
  
  @Smoke
  Scenario: CT_TC_19 validate the execute section has the created releases
    And Mouseover on integrations
    And Click on perform
    And Click on Execute
    Then Validate the execution page have the releases data

  @Smoke
  Scenario: CT_TC_20 search for the release and one release should display after search in execution
    And Mouseover on integrations
    And Click on perform
    And Click on Execute
    And Search for the release name "Unmonitored_Scripts_12"
    And Click on search button
    Then Validate only one release should display in execution page
