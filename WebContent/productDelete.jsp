<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<c:set var="row" value="${kfcDAO.delete(param.kfc_idx) }"/>

<section>
<c:if test="${row != 0 }">
	<h1>삭제 성공</h1>
<a href="${cpath }/home.jsp"><button>홈으로</button></a>
</c:if>


<c:if test="${row == 0 }">
	<h1>삭제 실패</h1>
<button onclick="history.back() ">이전으로</button></a>
</c:if>

</section>

</body>
</html>