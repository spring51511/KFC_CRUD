<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<section>

<h3>상품 추가</h3>

<form method="POST" action="productAdd_action.jsp" enctype="multipart/form-data">

<p>이미지<input type="file" name="uploadFile" placeholder="상품이미지" required></p>
<p>상품명<input type="text" name="menu" placeholder="상품이름" required ></p>
<p>종류<select name="kfc_kinds" required>
	<option value="">============종류 선택=============</option>
	<option value="버거세트">버거세트</option>
	<option value="치킨세트">치킨세트</option>
	<option value="음료">음료</option>
	<option value="사이드">사이드</option>
</select></p>

<p>가격<input type="number" name="price" placeholder="상품가격" required></p>
<p><textarea rows="30" cols="50" name="content" placeholder="싱품상세"></textarea></p>
<p><input type="submit" value="등록"></p>

</form>
</section>


</body>
</html>