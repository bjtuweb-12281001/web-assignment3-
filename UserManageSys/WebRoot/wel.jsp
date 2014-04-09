<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'wel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%
  	String username=(String)session.getAttribute("myName");
  	if(username == null)
  	{
  		response.sendRedirect("login.html");
  		return;
  	}
   %>
    登录成功<%=(String)session.getAttribute("myName") %> <br>
	<a href="login.jsp">返回登录界面</a>
	<hr>
	
  </body>
</html>
