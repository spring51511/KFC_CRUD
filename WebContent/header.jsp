<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kfc.*,user.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% request.setCharacterEncoding("UTF-8"); %>   

<c:set var="cpath" value="${pageContext.request.contextPath }" />
<c:set var="kfcDAO" value="${KFCDAO.getInstance()}"/>
<c:set var="userDAO" value="${UserDAO.getInstance()}"/>



<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>header</title>

<style>

body{
	margin: auto;
	padding: 0px;
/* 	border: 1px solid pink; */
	width: 1300px;
	
}

a{
text-decoration: none;
 
}
.mainList{
	margin: auto;
	padding: 10px;

}

h1 > a{
	list-style: none;
	text-decoration: none;
	font-size: 50px;
	margin-left: 10px;
	font-family: notokr,sans-serif;
	
}

h1{
	font-family: notokr,sans-serif;
	
}
ul > li {
	display: flex;
	list-style: none;
	text-decoration: none;
}
ul > li > a {

text-decoration: none;
padding: 10px;


}
a:visited { text-decoration:none;color:black;}

.mainList > ul{
	display: flex;
	padding: 10px;
	justify-content: flex-end;
	margin-top: 0px;
}

.category{

margin: auto;


}

.category >ul{

display: flex;
justify-content: center;

}

.category > ul> li> a> img{
	margin-left: 50px;
}


section{
 justify-content: center;	
/*  border: 1px solid blue; */
 text-align: center;
 margin-bottom: 10%;

}

table{
	justify-content: center;
	display:initial;
	border-collapse: collapse;
	
}

td,th{

	border: 1px solid gray;
	padding: 10px;
	
}
.loginMessage > h3{
	text-align: end;
	margin-bottom: 0px;
	margin-right: 20px;
	
}

.KFCList_All, .KFC_chicken, .KFC_BUGER{
		margin: auto;
		display: flex;
		text-align: center;
		width: 100%;
		flex-flow: wrap;
		padding: 10px;
	
	}
	
	.ALL{
		margin: 10px;
	}
	.AD>p>img{
		width: 100%;
		}


pre { white-space: pre-wrap; }

</style>


</head>
<body>

<h1><a style="color: red;" href="${cpath }/home.jsp">KFC</a></h1>

<div class="mainList">
	<div class="loginMessage">
		<c:if test="${not empty login }">
			<h3>${login.name }님 환영합니다.</h3>
		</c:if>
	</div>

	<ul>

	
		<li><a href="${cpath }/${empty login ? 'login.jsp':'logout.jsp' }">
			${empty login ? 'Login':'Logout' }</a></li>
		<li><a href="${cpath }/join.jsp">가입</a></li>
		<li><a href="${cpath }/mypage.jsp">내정보</a></li>
		<li><a href="${cpath }/userList.jsp">회원목록</a></li>
		<li><a href="${cpath }/productAdd.jsp">상품등록</a></li>

	
	</ul>
	

</div>


<div class="AD">
	<p><img src="${cpath }/upload/광고.png"></p>

</div>






</body>
</html>