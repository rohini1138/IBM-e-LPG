<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
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
<form action="DistributerLoginServlet" method="get">
<center>
<h1>Distributer Page</h1>
<h3>${msg}</h3>
<table>
<tr>
	<td>NAME :</td> 
	<td><input type="text" name="distributername" size="38"></td>
</tr>
<tr>

<td>DISTRICT :</td>
<td> <%
ArrayList<String> al1 = new ArrayList<String>(); 
  al1.add("Aurangabad");
  al1.add("Bandra(Mumbai Suburban district)"); 
  al1.add("Nagpur");
  al1.add("Pune"); 
  al1.add("Akola");
  al1.add("Chandrapur"); 
  al1.add("Jalgaon"); 
  al1.add("Parbhani");
  al1.add("Sholapur"); 
  al1.add("Thane");
  al1.add("Latur");
  al1.add("Mumbai-City"); 
  al1.add("Buldhana"); 
  al1.add("Dhule"); 
  al1.add("Kolhapur");
  al1.add("Nanded");
  al1.add("Raigad");
  al1.add("Amravati");
  al1.add("Nashik");
  al1.add("Wardha"); 
  al1.add("Ahmednagar"); 
  al1.add("Beed");
  al1.add("Bhandara");
  al1.add("Gadchiroli"); 
  al1.add("Jalna");
  al1.add("Osmanabad");
  al1.add("Ratnagiri"); 
  al1.add("Sangli");
  al1.add("Satara");
  al1.add("Sindudurg"); 
  al1.add("Yavatmal");
  al1.add("Nandurbar"); 
  al1.add("Washim");
  al1.add("Gondia"); 
  al1.add("Hingoli");
%>

<select name="district">
<% 

for(int i = 0 ; i < al1.size() ; i++){%>
<option value="<%=al1.get(i)%>"><%=al1.get(i)%></option>
<%}%>

</select>
</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="LOGIN"></td>
</tr>
</table>
<br>
<br>
<br>
<br>
<br>
<br>

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