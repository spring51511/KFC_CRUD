<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>





<section>
<h3>내정보 수정</h3>

<c:set var="dto" value="${userDAO.selectOne(login.userid) }"/>

<form method="POST" action="modify_action.jsp?idx=${dto.idx }"> 

<p>아이디<input type="text" name="userid" value="${dto.userid }" readonly></p>
<p>회원 번호<input type="number" name="idx" value="${dto.idx}" readonly></p>
<p>비밀 번호<input type="password" name="pw" value="${dto.pw}"></p>
<p>회원 이름<input type="text" name="name" value="${dto.name}"></p>
<p>전화 번호<input type="tel" name="phone" value="${dto.phone}"
pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
placeholder="전화번호 010-0000-0000"></p>

<p>이메일<input type="email" name="email" value="${dto.email}"></p>
<p>회원 주소<input type="text" name="address" value="${dto.address}"></p>

<p><input type="submit" value="제출"></p>

</form>

</section>


</body>
</html>