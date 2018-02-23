<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>社团列表main</title>
<link rel="icon" href="images/pande.png">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/css.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/css/main.css" />
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#searchmain{ font-size:12px;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(images/main/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:12px; background:url(images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:12px; line-height:40px;}
#main-tab td a{ font-size:12px; color:#548fc9;}
#main-tab td a:hover{color:#565656; text-decoration:underline;}
.bordertop{ border-top:1px solid #ebebeb}
.borderright{ border-right:1px solid #ebebeb}
.borderbottom{ border-bottom:1px solid #ebebeb}
.borderleft{ border-left:1px solid #ebebeb}
.gray{ color:#dbdbdb;}
td.fenye{ padding:10px 0 0 0; text-align:right;}
.bggray{ background:#f9f9f9}
</style>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：社团管理&nbsp;&nbsp;>&nbsp;&nbsp;社团列表</td>
  </tr>
  
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form method="post" action="">
	         <span>社团：</span>
	         <input type="text" name="" value="" class="text-word">
	         <input name="" type="button" value="查询" class="text-but">
	         </form>
         </td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="community_add.jsp" target="mainFrame" onFocus="this.blur()" class="add">添加社团</a></td>
  		</tr>
	</table>
    </td>
  </tr>
  
  
 <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th align="center" valign="middle" class="borderright tda">序号</th>
        <th align="center" valign="middle" class="borderright tda">活动名称</th>
        <th align="center" valign="middle" class="borderright tda">活动时间</th>
        <th align="center" valign="middle" class="borderright tda">举办社团</th>
        <th align="center" valign="middle" class="borderright">活动地点</th>
        <th align="center" valign="middle" class="borderright">活动简介</th>
        <th align="center" valign="middle">编辑</th>
      </tr>
      
      <c:forEach items="${activity }" var="act" varStatus="status">
      <tr class="bggray">
        <td align="center" valign="middle" class="borderright borderbottom">${status.index+1 }</td>
        <td align="left" valign="middle" class="borderright borderbottom tdb">${act.activityName}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${act.activityDate }</td>
        <td align="left" valign="middle" class="borderright borderbottom tdb">${act.communityName }</td>
        <td align="center" valign="middle" class="borderright borderbottom">${act.activityPlace }</td>
        <td align="left" valign="middle" class="borderright borderbottom tdb">${act.activityInfo }</td>
        <td align="center" valign="middle" class="borderbottom"><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">修改</a><span class="gray">&nbsp;|&nbsp;</span><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">删除</a></td>
      </tr>
      </c:forEach>
      
    </table></td>
    </tr>
  
  <tr>
    <td align="left" valign="top" class="fenye">共有${page.itemCont} 条记录，当前${page.pageCurrent}/${page.pageCont}页分页
        &nbsp; &nbsp; &nbsp;
         <c:choose>
         	<c:when test="${page.pageCurrent==1 }">
         		<a href="Query?lru=clist&cpage=${page.pageCurrent }">首页</a>
         		<a href="Query?lru=clist&cpage=${page.pageCurrent }">上一页</a>
         	</c:when>
         	<c:otherwise>
		         <a href="Query?lru=clist&cpage=1">首页</a>
         	 	<a href="Query?lru=clist&cpage=${page.pageCurrent-1}">上一页</a>
         	</c:otherwise>
         </c:choose>   

           <c:choose>
         	<c:when test="${page.pageCurrent==page.pageCont }">
         		<a href="Query?lru=clist&cpage=${page.pageCurrent }">下一页</a>
         		<a href="Query?lru=clist&cpage=${page.pageCurrent }">尾页</a>
         	</c:when>
         	<c:otherwise>
		         <a href="Query?lru=clist&cpage=${page.pageCurrent+1}">下一页</a>
          	     <a href="Query?lru=clist&cpage=${page.pageCont}">尾页</a></c:otherwise>
         </c:choose></tr></tr>
</table>
</body>
</html>