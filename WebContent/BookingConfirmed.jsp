<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
               
<h1>Booking Confirmed</h1>
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
	PreparedStatement ps = conn.prepareStatement("select b.serialno,b.customerid,b.distributer,b.cylinderno,b.name,b.bookingdate,r.address,b.lotno,r.mobileno,r.stdcode,r.telephone from register r inner join booking b on r.customerid = b.customerid where r.customerid = ? order by b.serialno desc fetch first row only");
	ps.setString(1,(String)session.getAttribute("customerid"));
	ResultSet rs = ps.executeQuery();
	int i = 0;
	while(rs.next())
	{ 
	
%>
<form action="BookConfirmed" method="get">
<fieldset>
<legend align="right" >
<font color="#000080" size=+3 face=Arial>Booking Acknowledgement</font>
</legend>
<br>
<br>
<br>
<table border="12">
<tr>
<th colspan="2"><h3>Receipt</h3></th>
</tr>

<tr>
<td>Receipt no :</td>
<td><%=rs.getInt(1) %></td>
</tr>

<tr>
<td>Customer ID :</td>
<td><%=rs.getInt(2) %></td>
</tr>

<tr>
<td>Distributer Name :</td>
<td><%=rs.getString(3).toUpperCase() %></td>
</tr>

<tr>
<td>Cylinder Serial No :</td>
<td><%=rs.getInt(4) %></td>
</tr>

<tr>
<td>Customer's Name : </td>
<td><%=rs.getString(5).toUpperCase() %></td>
</tr>

<tr>
<td>Booking Date :</td>
<td><%=rs.getString(6) %></td>
</tr>

<tr>
<td>Address :</td>
<td><%=rs.getString(7) %></td>
</tr>

<tr>
<td>Base Rate :</td>
<td>RS 436.41/-</td>
</tr>

<tr>
<td>VAT :</td>
<td>RS 13.09/-</td>
</tr>

<tr>
<td>Rebate :</td>
<td>RS 00.00/-</td>
</tr>

<tr>
<td>TotalCost :</td>
<td>RS 449.50/- </td>
</tr>

<tr>
<td>Dispatch Lot no :</td>
<td><%=rs.getInt(8) %></td>
</tr>

<tr>
<td>Telephone :</td>
<td>+91<%=rs.getString(9) %> / <%=rs.getString(10) %><%=rs.getString(11) %></td>
</tr>


</table>


<%-- Receipt no : <%=rs.getInt(1) %>
<br>
<br>
<br>


Customer ID : <%=rs.getInt(2) %>
<br>
<br>
<br>




Distributer Name : <%=rs.getString(3)%>
<br>
<br>
<br>



Cylinder Serial No : <%=rs.getInt(4) %>
<br>
<br>
<br>



Customer's Name : <%=rs.getString(5) %>
<br>
<br>
<br>



Booking Date : <%=rs.getString(6) %>
<br>
<br>
<br>



Address : <%=rs.getString(7) %>
<br>
<br>
<br>



Base Rate : Rs 436.41/-
<br>
<br>
<br>




VAT : Rs 13.09/-
<br>
<br>
<br>



Rebate : Rs 0.00/-
<br>
<br>
<br>



Total Cost : Rs 449.50/-
<br>
<br>
<br>




Dispath Lot no : <%=rs.getInt(8)%>
<br>
<br>
<br>



Telephone Number : +91<%=rs.getString(9) %> / <%=rs.getString(10) %><%=rs.getString(11) %>
<br>
<br>
<br>

 --%>
 <br>
<input type="submit" value="Return to UserMain Page">
</fieldset>
</form>
<br>
<br>
<br>

<%
}
}
catch(SQLException sqle)
{
	System.out.print(sqle.getMessage());
	sqle.printStackTrace();
}
}
else
{
	getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
} 
 %>

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