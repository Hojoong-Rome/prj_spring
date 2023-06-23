<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML>
<head>
	<title>Code List</title>
	<style type="text/css">
		.good{
			width: 50px;
			border: 1px solid black;
		}
	</style>
</head>
<body>
	<c:choose>
		<c:when test="${fn:length(list) eq 0}">
			<tr>
				<td class="text-center" colspan="9">There is no data!</td>
			</tr>	
		</c:when>
		<c:otherwise><%--${list}: 자바에서 넘겨준 객체 이름 --%><!-- var="list" jstl 블럭에서 사용할 변수 이름-->
			<c:forEach items="${list}" var="list" varStatus="status">
					<div class="good"><c:out value="${list.seq}"></c:out></div>
					<div class="good"><c:out value="${list.name}"></c:out></div>
					<div class="good"><c:out value="${list.codeGroup_seq}"></c:out></div><br>
			</c:forEach>
		</c:otherwise>
	</c:choose>	  	
</body>
