<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<jsp:useBean id="user" class="user.UserDTO" scope="page"/>
<jsp:setProperty property="*" name="user"/>

<c:set var="login" value="${userDAO.login(user) }" scope="session"/>

<section>
	<h3>${not empty login ? '로그인 성공' : '로그인 실패' }</h3>
<%-- 	<h3>${empty login ? 'login': '' }</h3> --%>

	<a href="${cpath }/home.jsp"><button>홈으로</button></a>
	<a href=""></a>
</section>


</body>
</html>