<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="header.jsp" %>


<section>

<h3>로그인</h3>

<form method="POST" action="login_action.jsp">
<p><input type="text" name="userid" placeholder="아이디" required></p>
<p><input type="password" name="pw" placeholder="비밀번호" required></p>

<p><input type="submit" value="로그인"></p>

</form>

</section>

</body>
</html>