Feature: Validate Login Functionality 

Scenario Outline: Navigating to Landing Page and then Logging in 

	Given Initialize the browser with chrome 
	And Navigate to QAClickAcademy site 
	And Once landed click on login link 
	When Enter <username> and <password> to login 
	Then Verify the user login 
	Examples: 
		|username   	 	|password	|
		|test99@gmail.com	|123456		|
		|test123@gmail.com	|867474		|	