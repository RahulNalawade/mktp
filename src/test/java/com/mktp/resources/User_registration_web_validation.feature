Feature: User Registration

@register
Scenario Outline: User Registration validation
	Given user launch login web page
	When user click register button
	And user accept point
	And user verify signup page
	And user enter invalid mobile number "<MobileNumber>"
	And user enter invalid email id "<EmailId>"
    And user enter invalid PAN number "<PAN>"
    And user <SerialNo> set birthdate 
    And user verify validation error
    And user tick the checkbox of tnc and privacy policy
    Examples:
    
    |SerialNo|MobileNumber|EmailId   |PAN        |
    |1        |11111       |rahul     |ABCDEFG.12 |
    |2        |123456789   |nalawade@ |ABCD123    |
    |3        |000000	   |ajit.com  |ABCcd      |
    |4        |1234567     |@test     |0000AB     |
    
@register
Scenario Outline: User sign in validation
	Given user launch login web page
	And user verify sign in page
	And user enter invalid email id "<EmailId>" on sign in form
    And user enter password "<Password>"
    And user click on sign in button
    And user verify sign in validation error
    Examples:
    
    |EmailId  					 |Password   |
    |rahul.nalawade@gmail.com    |1234567890 |
    #|nalawade@   				 |10923452   |
    #|ajit.com		             |102232323  |
    
@register
Scenario Outline: User sign in form validation
	Given user launch login web page
	And user verify sign in page
	And user enter invalid email id "<EmailId>" on sign in form
    And user enter password "<Password>"
    And user verify sign in validation error
    Examples:
    
    |EmailId  					 |Password   |
    |nalawade@   				 |10923452   |
    |ajit.com		             |102232323  |
    |ajit.com.sas		         |123456     |
    |asd@testing                 |pass@12345 |
	