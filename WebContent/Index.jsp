<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="demos.Demo1" %>
    <%@ page import="demos.Demo2" %>
    
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
	<li><a href="Index.jsp" title="Home"><span>Home</span></a></li>
	<li><a href="FormFilling.jsp" title="Voice Assisted Task"><span>Voice Assisted Task</span></a></li>
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
		<li><a href="FormFilling.jsp">Assisted task!</a></li>
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
	
<h2>Task Assistance ++</h2>
<p><a>An RIT Student Initiative</a><br />
<p><a href="FormFilling.jsp">Voice Assisted Task </a>- &quot; This is where a user can create a voice assisted task blah blah blah!!! TO BE HONEST this is a multi million $ venture and that is whey we are doing it! <br />
   Yes that is why our website is AWESOME!!</p>

<p><a href="#">Non Assisted Task </a>- &quot; This is for you lazy people.Who just want to sit on your butt and see the work get done!!!<br />
 we are damn awesome that we help lazy people like you as well...All we want is money in return!your MONEY! <a href="#"></a> &quot; </p>
  
<p><a href="#">Motivation </a>- &quot; We have Taizun Dalal in our group and he is truely our motivation! we are no good!<br />
 
</div>
</div>

<div id="wrapper-footer">
<div id="footer">
Design by <a href="#">RIT Students!</a> | copyright 2012 TaskAssistance
</div>
</div>

</body>
</html>
<%
String myIP = request.getRemoteAddr();
System.out.println("Its running");
Demo1 myDemo = new Demo1();
myDemo.sayHelloWorld(myIP);

//Demo2 myDemo2 = new Demo2();
//myDemo2.sayHelloWorld();
%>