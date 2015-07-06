<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"[]>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">
<head>
    <!--
    Created by Artisteer v3.0.0.39952
    Base template (without user's data) checked by http://validator.w3.org : "This page is valid XHTML 1.0 Transitional"
    -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>New Page</title>
    <meta name="description" content="Description" />
    <meta name="keywords" content="Keywords" />


    <link rel="stylesheet" href="style.css" type="text/css" media="screen" />
    <!--[if IE 6]><link rel="stylesheet" href="style.ie6.css" type="text/css" media="screen" /><![endif]-->
    <!--[if IE 7]><link rel="stylesheet" href="style.ie7.css" type="text/css" media="screen" /><![endif]-->

    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript" src="script.js"></script>
</head>
<body>
<div id="art-main">
    <div class="art-sheet">
        <div class="art-sheet-tl"></div>
        <div class="art-sheet-tr"></div>
        <div class="art-sheet-bl"></div>
        <div class="art-sheet-br"></div>
        <div class="art-sheet-tc"></div>
        <div class="art-sheet-bc"></div>
        <div class="art-sheet-cl"></div>
        <div class="art-sheet-cr"></div>
        <div class="art-sheet-cc"></div>
        <div class="art-sheet-body">
<div class="art-nav">
	<div class="art-nav-l"></div>
	<div class="art-nav-r"></div>
<div class="art-nav-outer">
	<ul class="art-hmenu">
			
	</ul>
</div>
</div>
<!-- orenge plate -->
<div class="cleared reset-box"></div>
<div class="art-header">
                <div class="art-header-clip">
                <div class="art-header-center">
                    <div class="art-header-png"></div>
                    <div class="art-header-jpeg"></div>
                </div>
                </div>
                <div class="art-logo">
                                  <a href="#" class="art-rss-tag-icon" title="RSS"></a>
                                 <h1 class="art-logo-name"><a href="./index.html">GASOLINE PRODUCTS</a></h1>
                                                 <h2 class="art-logo-text">No.1 Gas Products In MAHARASHTRA..!!</h2>
                                </div>
</div>
    
   
<div class="art-block">
    <div class="art-block-body">
                <div class="art-blockcontent">
                    <div class="art-blockcontent-body">
               <p></p>
<center><h1> Book Cylinder</h1></center>
<%  
response.setHeader("Pragma","no-cache");  
response.setHeader("Cache-Control","no-store");  
response.setHeader("Expires","0");  
response.setDateHeader("Expires",-1);  


%>
<%
String username = (String)session.getAttribute("usernameLogin");
System.out.println(username);
if(username!=null)
{

try
{
	
	Class.forName("com.ibm.db2.jcc.DB2Driver");
	Connection conn = DriverManager.getConnection("jdbc:db2://localhost:50000/ELPG","Administrator","password");
	PreparedStatement ps = conn.prepareStatement("SELECT * FROM REGISTER WHERE USERNAME = ?");
	ps.setString(1,username);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next())
	{ 
%>
<form action="BookCylinderServlet" method="get" >
<center>
<table>
<tr>
<td>CUSTOMER-ID</td> 
<td><input type = "text" name="customerid" disabled="disabled" value="<%=rs.getString(1)%>" size="30" /></td>
</tr>

<tr>
<td>USERNAME </td> 
<td><input type = "text" name="username" disabled="disabled" value="${usernameLogin}" size="30"/></td>
</tr>
<tr>
<td>ENTER PASSWORD </td> 
<td><input type = "password" name="password" size="30"/></td>
</tr>
<tr>
<td>DATE OF BOOKING </td> 
<td><input type = "text" name="bookingdate" value="<%=new Date().toString()%>" size="30" disabled="disabled" size="40"/></td>
</tr>

<tr>
<td>ADDRESS</td> 
<td><input onclick="function1()" type = "text" width="15" height="15" name="bookingdate" value="<%=rs.getString(10)%>" disabled="disabled" /></td>
</tr>
<%	
	session.setAttribute("customerid",rs.getString(1));
	}
	}
	catch(SQLException sqle)
	{
		System.out.println(sqle.getMessage());
	}
	}
	else
	{
		getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
	}
%>

</table>
<br></br>
<input type = "submit" value="Book My Gas Cylinder" onclick="msg()" />
</center>

</form>
                <p></p>
<p></p>                
                                		<div class="cleared"></div>
                    </div>
                </div>
		<div class="cleared"></div>
    </div>
</div>

                      <div class="cleared"></div>
                    </div>
                 
 <div class="art-block">
    <div class="art-block-body">
                <div class="art-blockcontent">
                    <div class="art-blockcontent-body">
                <div>
  
</div>                
                                		<div class="cleared"></div>
                    </div>
                </div>
		<div class="cleared"></div>
    </div>
</div>

                      <div class="cleared"></div>
                    </div>
                </div>
     <div>       
            <div class="cleared"></div>
            <div class="art-footer">
                <div class="art-footer-t"></div>
                <div class="art-footer-l"></div>
                <div class="art-footer-b"></div>
                <div class="art-footer-r"></div>
                <div class="art-footer-body">
                    <a href="#" class="art-rss-tag-icon" title="RSS"></a>
                            <div class="art-footer-text">
                                <p>Copyright © 2014. All Rights Reserved.</p>
                                                            </div>
                    <div class="cleared"></div>
                </div>
            </div>
    		<div class="cleared"></div>
       
    </div>
    <!-- <div class="cleared"></div>
    <p class="art-page-footer"><a href="http://www.2createawebsite.com/artisteer">Website Template created with Artisteer</a>.</p>
</div> -->
</body>
</html>
