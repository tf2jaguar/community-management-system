<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="pande.png">
    <title>社团管理</title>
</head>
<link href="css/regist.css" type="text/css" rel="stylesheet" />
<!-- js files -->
	<script src="js/regist.js"></script>
<!-- /js files -->
</head>
<body>
    <div class="wrap">
        <div class="container">
            <h1>注册</h1><br>
            <c:if test="${param.rs =='success' }"><font -size="4px"; color=blue>&nbsp;&nbsp;&nbsp;<b>注册成功，请登录</b></font></c:if>
    		<c:if test="${param.rs =='fail' }"><font -size="4px"; color=red>&nbsp;&nbsp;&nbsp;<b>注册失败，请重新尝试</b></font></c:if>
    		<c:if test="${param.rs =='exist' }"><font -size="4px"; color=red>&nbsp;&nbsp;&nbsp;<b>登录名已存在</b></font></c:if>
   
            <form action="Regist" method="post" name="myfor">
                <input id="name"  name="username" type="text" placeholder="用户名" onblur="checkName();"/>
                <input id="password" name="userpass" type="password" placeholder="密码" onblur="checkPassword();"/>
                <input id="passwordAgain" name="repass" type="password" placeholder="确认密码" onblur="checkPassword();"/>
                <input id="address" name="email" type="text" placeholder="邮箱" onblur="checkAddress"/>
                <input id="tel" name="phone" type="text" placeholder="电话" onblur="checkTel();"/>
                <input type="submit" value="注 册" onclick="return registCheck(this)"/>
            	<input name="ope" type="hidden"  value="index"/>
            </form>
            <div id="regst">
                如果您已有账号，请点击这里<a href="login.jsp" class="link">登录</a>
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