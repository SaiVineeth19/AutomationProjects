Feature: Application Login 

Scenario: Home Page default login 
	Given User is on an e-commerce landing page 
	When User login into application with username and password 
	Then Home Page is populated 
	And default items are displayed