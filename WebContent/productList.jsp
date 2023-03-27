<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="home.jsp" %>



<c:set var="kfc_kinds" value="${param.kfc_kinds }"/>


<%-- <c:set var="kind" value="${param.kfc_kinds }"/> --%>
<%-- <%-- <c:if test="${kfc_kinds != null }"> --%>


<c:if test="${empty kfc_kinds }">

	<div class="KFCList_All">
		<c:forEach var="dto" items="${kfcDAO.selectList() }">
	<%-- 	<c:if test="${kfc_kinds == null }"> --%>
				<div class="ALL">
					<div ><a href="productDetail.jsp?kfc_idx=${dto.kfc_idx }">
						<img  class="KFCImg" src="${cpath }/upload/${dto.imgPath }" height="200px"></a></div>
					<div class="menu">${dto.menu }</div>
					<div class="price">
						<fmt:formatNumber value="${dto.price }" type="currency"/>
					</div>	
				</div>
	<%-- 		</c:if>	 --%>
		</c:forEach>
	</div>
</c:if>



<c:if test="${not empty kfc_kinds }">
<div class="KFC_chicken">
	<c:forEach var="dto" items="${kfcDAO.selectKinds(kfc_kinds) }">
		<div class="ALL">
			<div><a href="productDetail.jsp?kfc_idx=${dto.kfc_idx }">
			<img src="${cpath }/upload/${dto.imgPath}" height="200px"></a></div>
			<div>${dto.menu }</div>
			<div>
				<fmt:formatNumber value="${dto.price }" type="currency"/>
			</div>
		</div>
</c:forEach>
</div>
</c:if>




</body>
</html>