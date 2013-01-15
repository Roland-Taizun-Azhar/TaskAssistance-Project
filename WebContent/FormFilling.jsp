<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="demos.Demo1" %>
    <%@ page import="demos.Demo2" %>
    <%System.out.println("Its running");
    String myIP = request.getRemoteAddr();
		Demo1 myDemo = new Demo1();
		myDemo.promptInFormFilling(myIP);
		
		//Demo2 myDemo2 = new Demo2();
		//myDemo2.sayHelloWorld();
     %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Task Assistance</title>
	<link rel="stylesheet" type="text/css" href="style.css" />
</head>

<body>
<div id="wrapper-menu-top">
<div id="menu-top">
	<ul>
	<li><a href="#" title="Home"><span>Home</span></a></li>
	<li><a href="#" title="Voice Assisted Task"><span>Voice Assisted Task</span></a></li>
	<li><a href="#" title="Non Assisted Task"><span>Non Assisted Task</span></a></li>
	<li><a href="#" title="Complete A Task"><span>Complete A Task</span></a></li>
    <li><a href="#" title="About Us"><span>About Us</span></a></li>
	</ul>
</div><!--menu-top-->
</div><!--wrapper-menu-top-->

<div id="wrapper-header">
<div id="header">
<div id="wrapper-header2">
<div id="wrapper-header3">
	<h1>TASK ASSISTANCE ++</h1>
</div>
</div>
</div>
</div>

<div id="wrapper-content">
<div id="wrapper-menu-page">
	<div id="menu-page">
	<h3>Need Help?</h3>
	<ul>
		<li><a href="#">Assisted task!</a></li>
		<li><a href="#">Non Assisted task!</a></li>
	</ul>
    
    <h3>Want To Help?</h3>
	<ul>
		<li><a href="#">Complete a task!</a></li>
	</ul>
    
	<p>&nbsp;</p>
</div><!--menu-page-->
</div>

<div id="content">
<form action="StoreXML" method="post">
Please Fill the form here: 
  <table class="form">
			<tr>
				<th><label for="input-one"><strong>Name of Task:</strong></label></th>
				<td><input class="inp-text" name="NameOfTask" id="NameOfTask" type="text" size="30" /></td>
			</tr>

			<tr>
				<th><label for="input-two"><strong>Email Address:</strong></label></th>
				<td><input class="inp-text" name="EmailAddress" id="EmailAddress" type="text" size="30" /></td>
			</tr>

			<tr>
				<th><label for="input-three"><strong>Work/Home Number:</strong></label></th>
				<td><input class="inp-text" name="Number" id="Number" type="text" size="30" /></td>
			</tr>
				
            <tr>
				<th><label for="input-three"><strong>Wager:</strong></label></th>
				<td><input class="inp-text" name="Wager" id="Wager" type="text" size="8"/>
				$</td>
			</tr>
                
			<tr>
				<th class="message-up"><label for="message"><strong>Breif Task Description:</strong></label></th>
				<td>
				<textarea name="TaskDescription" id="message" cols="30" rows="5"></textarea>
				</td>
			</tr>		
			
			<tr>
        <td class="submit-button-left" colspan="2"><input name="Reset" type="reset" class="submit-text" value="RESET FORM" /></td>
		<td class="submit-button-right" colspan="2"><input class="submit-text" type="submit" value="SUBMIT" /></td>
			</tr>
            
		</table> 
		</form>
</div>

</div>

<div id="wrapper-footer">
<div id="footer">
Design by <a href="#">RIT Students!</a> | copyright 2012 TaskAssistance
</div>
</div>
</body>
</html>