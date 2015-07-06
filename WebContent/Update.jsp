<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*;"%>
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
    
    <% 
    try
    {
    
   String  userid=(String)session.getAttribute("usernameLogin");
    String sql="select * from REGISTER where username=?";
    Class.forName("com.ibm.db2.jcc.DB2Driver");
    Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/ELPG","Administrator","password");
    System.out.println("Connected");
    PreparedStatement ps=con.prepareStatement(sql);
    ps.setString(1, userid);
    ResultSet rs=ps.executeQuery();
    System.out.println("executeUpdate");
    %> 
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
<form action="Update" method="post">
<table border="1">
		<%
        while(rs.next())
        {
        
        %>
	<tbody>
		<tr>
			<td width="229">First Name</td>
			<td width="170"><input type="text" name="fname" value="<%=rs.getString(4)%>"size="27" /></td>
		</tr>
		
		<tr>
			<td width="229">Last Name</td>
			<td width="170"><input type="text" name="lname" value="<%=rs.getString(5)%>"size="27" /></td>
		</tr>
		
		<tr>
			<td width="229">Gender</td>
			<td width="170"><input type="text" name="gender" value="<%=rs.getString(6)%>"size="27" disabled="disabled"/></td>
		</tr>
		<tr>
			<td width="229">DOB</td>
			<td width="170"><input type="text" name="dob" value="<%=rs.getString(7)%>"size="27" /></td>
		</tr>
		<tr>
			<td width="229">STATE</td>
			<td width="170"><input type="text" name="state" value="<%=rs.getString(8)%>" size="27" /></td>
		</tr>
		<tr>
			<td width="229">DISTRICT</td>
			<td width="170"><input type="text" name="district" value="<%=rs.getString(9)%>"size="27" /></td>
		</tr>
		
		<tr>
			<td width="229">Address</td>
			<td width="170"><input type="text" name="addr" value="<%=rs.getString(10)%>" size="27" /></td>
		</tr>
		<tr>
			<td width="229">pincode</td>
			<td width="170"><input type="text" name="pincode" value="<%=rs.getString(11)%>"size="27" /></td>
		</tr>
		<tr>
			<td width="229">Distributer</td>
			<td width="170"><input type="text" name="distributer" value="<%=rs.getString(12)%>"size="27" /></td>
		</tr>
		<tr>
			<td width="229">aadharno</td>
			<td width="170"><input type="text" name="aadharno" value="<%=rs.getString(13)%>"size="27" disabled="disabled"/> </td>
		</tr>
		<tr>
			<td width="229">Mobileno</td>
			<td width="170"><input type="text" name="mobileno" value="<%=rs.getString(14)%>"size="27" /></td>
		</tr>
		<tr>
			<td width="229">stdcode</td>
			<td width="170"><input type="text" name="stdcode" value="<%=rs.getString(15)%>"size="27" /></td>
		</tr>
		<tr>
			<td width="229">telephone</td>
			<td width="170"><input type="text" name="telephone" value="<%=rs.getString(16)%>"size="27" /></td>
		</tr>
		<tr>
			<td width="229">email</td>
			<td width="170"><input type="text" name="email" value="<%=rs.getString(17)%>"size="27" /></td>
		</tr>
		
		<tr>
			<td align="center"  colspan="2" width="170"><input type="submit" name="submit" value="UPDATE" /></td>
		</tr>
	</tbody>
</table>

<%
        }        
        }catch(Exception e)
                {
        e.printStackTrace(); 
        }
%>

${msg}
<br></br>
<br></br>
<br></br>

<a href="UpdateSuccess.jsp">click here</a>&nbsp;&nbsp;&nbsp;&nbsp;to continue
</form>
                
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
