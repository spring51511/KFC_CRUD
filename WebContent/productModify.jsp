<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<section>

<c:set var="dto" value="${kfcDAO.selectOne(param.kfc_idx) }"/>


<h1>상품 수정</h1>

<form method="POST" enctype="multipart/form-data" action="productModify_action.jsp?kfc_idx=${dto.kfc_idx }">

<input type="text" name="menu" value="${dto.menu }">
<input type="number" name="price" value="${dto.price }">
<p><textarea rows="30" cols="50" name="content">${dto.content }</textarea></p>
<p><select name="kfc_kinds" >
	<option value="">-------카테고리 선택--------</option>
	<option value="치킨세트">치킨세트</option>
	<option value="버거세트">버거세트</option>
	<option value="사이드">사이드</option>
	<option value="음료">음료</option>
</select></p>

<input type="file" name="uploadFile" required>


<input type="submit" value="제출">


</form>


</section>


</body>
</html>