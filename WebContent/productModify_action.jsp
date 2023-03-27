<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<c:set var="dto" value="${FileUtil.getDTO(pageContext.request)}"/>


<section>

<h1>${kfcDAO.modify(dto, param.kfc_idx) != 0 ? '수정성공' : '수정실패' }</h1>

<a href="productDetail.jsp?kfc_idx=${param.kfc_idx}"><button>수정내용확인</button></a>

</section>
</body>
</html>