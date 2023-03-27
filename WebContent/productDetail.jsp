<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="dto" value="${kfcDAO.selectOne(param.kfc_idx) }"/>

<section>

<div class="Product_Detail">

<div><img src="${cpath }/upload/${dto.imgPath }" ></div>
<div>${dto.menu }</div>
<div>${dto.kfc_kinds }</div>
<fmt:formatNumber value="${dto.price }" type="currency"/>

<pre>${dto.content }</pre>

<a href="${cpath }/productModify.jsp?kfc_idx=${dto.kfc_idx }"><button>수정</button></a>
<a href="${cpath }/productDelete.jsp?kfc_idx=${dto.kfc_idx }"><button>삭제</button></a>

</div>


</section>
</body>
</html>