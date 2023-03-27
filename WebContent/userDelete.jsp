<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<section>

<h1>${userDAO.delete(param.idx) != 0 ? '삭제 성공':'삭제실패' }</h1>

<%

	session.removeAttribute("login");

	session.invalidate();
	response.sendRedirect(request.getContextPath());



%>


<a href="${cpath }/home.jsp"><button>홈 으로</button></a>

</section>
</body>
</html>