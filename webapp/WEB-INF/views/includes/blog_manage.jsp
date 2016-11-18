<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>




<c:choose>
	<c:when test="${empty authUser }">

	</c:when>
	<c:otherwise>
		<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">기본설정</a></li>
		<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/category">카테고리</li>
		<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/write">글작성</a></li>


	</c:otherwise>
</c:choose>