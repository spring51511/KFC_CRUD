<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!-- 파일은 multipart/form-data형태로 넘어온 형식은 바이너리 형태로 넘어와서 
jsp:useBean 으로는 처리할 수 없다. -->

<c:set var="dto" value="${FileUtil.getDTO(pageContext.request)}"/>
<section>
	<h3>${kfcDAO.insert(dto) != 0 ?'추가성공':'추가실패'}</h3>
	
	<a href="home.jsp"><button>홈으로</button></a>
	
</section>
</body>
</html>