<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>


<!DOCTYPE HTML>
<head>
	<title>CodeGroupList</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
	<div>
		<form name="formList" method="get"><!-- post-get 간 변경 가능 -->
		    <select class="form-select" aria-label="typeSelect" name="shOption">
			    <option value="2">Name</option>
			    <option value="3">Seq</option>
		    </select>
		    <div class="mb-3">
			    <label for="searchForm" class="form-label">Search</label>
			    <input type="text" class="form-control" id="searchForm" aria-describedby="searchForm" name="shKeyword">
		    </div>
		    <button type="button" class="btn btn-primary" id="btn">Submit</button>
	    </form>
    </div>
	<c:choose>
		<c:when test="${fn:length(list) eq 0}">
		</c:when>
		<c:otherwise><%--${list}: 자바에서 넘겨준 객체 이름 --%><!-- var="list" jstl 블럭에서 사용할 변수 이름-->
			<c:forEach items="${list}" var="list" varStatus="status">
				<c:out value="${list.seq}"></c:out>
				<c:out value="${list.name}"></c:out>
				<c:out value="${list.delNy}"></c:out><br>
			</c:forEach>
		</c:otherwise>
	</c:choose>	  	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
	<script type="text/javascript">
		
		$("#btn").on("click", function(){
			
			$("form[name=formList]").attr("method", "get");
			$("form[name=formList]").attr("action", "/codeGroupList").submit();
			
		});
	
	</script>
</body>
