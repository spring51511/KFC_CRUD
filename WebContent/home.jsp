<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>



<div class="category">

	<ul>

		<li><a href="${cpath }/productList.jsp?kfc_kinds=치킨세트"><img src="${cpath }/upload/치킨세트.png" style="height: 100px;"></a></li>
		<li><a href="${cpath }/productList.jsp?kfc_kinds=버거세트"><img src="${cpath }/upload/버거세트.png" style="height: 100px;"></a></li>	
		<li><a href="${cpath }/productList.jsp?kfc_kinds=사이드"><img src="${cpath }/upload/사이드.png" style="height: 100px;"></a></li>
		<li><a href="${cpath }/productList.jsp?kfc_kinds=음료"><img src="${cpath }/upload/음료.png" style="height: 100px;"></a></li>
	
	</ul>


</div>


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




</body>
</html>