<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<jsp:useBean id="user" class="user.UserDTO"/>
<jsp:setProperty property="*" name="user"/>

<c:set var="flag" value="${userDAO.modify(user, param.idx) }"/>
<c:set var="login" value="${userDAO.login(user)}" scope="session"/>
<section>
	<h3>${flag != 0 ? '수정성공' :'수정실패' }</h3>
<%-- 	<h3>${flag }</h3> --%>
	
	<a href="${cpath }/mypage.jsp"><button>My page</button></a>
	<a href="${cpath }/home.jsp"><button>Home</button></a>


</section>



</body>
</html>