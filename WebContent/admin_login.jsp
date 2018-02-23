<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 	<link rel="icon" href="./images/pande.png">
    <title>Admin Login</title>
</head>
	<!-- css files -->
     <link href="css/login.css" type="text/css" rel="stylesheet" />
	<!-- css files -->
	<!-- js files -->
	<script src="js/login.js"></script>
	<!-- /js files -->
</head>
<body>
 
    <div class="wrap">
        <div class="container">
            <h1>Admin Login</h1>
             <c:if test="${param.error =='uname' }"><font color=red >用户名密码错误</font></c:if>
            
            <form name="myform" action="Login" method="post">
            <%if(request.getAttribute("return_uri")!=null) {%>
				<input type="hidden" name="return_uri" value="<%=request.getAttribute("return_uri") %>"/>
		     <%} %>
                <input name="username" type="text" placeholder="user login"/>
                <input name="userpass" type="password" placeholder="password" />
                <input type="submit" value="Login"  onclick="return check(this)"/>
                <input name="lru" type="hidden" value="login"/>
            	<input name="log" type="hidden" value="admin"/>
            </form>
			
			<div id="regst">
                If you forget password, please contact the &nbsp;&nbsp;<a href="#">Administrator</a>
            </div>
            
        </div>
        <ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</body>
</html>