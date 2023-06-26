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
	<form name="formList">
		<div class="input-group">
			<input type="text" name="item" value="<c:out value='${item.seq }'></c:out>" class="form-control bg-light border-0 small" aria-label="search">
			<input type="text" name="item" value="<c:out value='${item.name }'></c:out>" class="form-control bg-light border-0 small" aria-label="search">
			<button type="button" id="btn">button</button>
		</div>
	</form>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$("#btn").on("click", function(){
			
			$("form[name=formList]").attr("action", "get");
			$("form[name=formList]").attr("action", "/codeGroupList").submit();
			
		});	
	</script>
	
</body>
