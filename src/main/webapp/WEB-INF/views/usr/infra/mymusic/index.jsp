<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyMusic</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../../../resources/css/mymusic.css">
    <script src="https://kit.fontawesome.com/b2daa60225.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <script src="../../../../resources/js/mymusic.js"></script>
</head>
<body>
    <header>
        <div class="btnContainer">
            <div class="d-grid gap-2 d-md-block">
                <a href="#"><button class="btn btn-secondary" type="button">Main</button></a>
                <a href="mymusicAi"><button class="btn btn-secondary" type="button">AI</button></a>
                <a href="sub/sub02.html"><button class="btn btn-secondary" type="button">Write</button></a>
                <a href="sub/sub03.html"><button class="btn btn-secondary" type="button">Notice</button></a>
            </div>
        </div>  
    </header>
    <div class="container">
        <div class="main">
            <div class="article1">
                <h3>AI로 음악 생성</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam sed blandit nibh. Aliquam erat volutpat. Suspendisse potenti.</p>
                <button class="btn btn-primary" type="submit">Button</button>
            </div>
            <div class="article2">
                <h3>음악 제작 의뢰하기</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam sed blandit nibh. Aliquam erat volutpat. Suspendisse potenti.</p>
                <button class="btn btn-primary" type="submit">Button</button>
            </div>
            <div class="article3">
                <h3>내 음악 업로드하기</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam sed blandit nibh. Aliquam erat volutpat. Suspendisse potenti.</p>
                <button class="btn btn-primary" type="submit">Button</button>
            </div>
        </div>
    </div>
    <div class="mypage">
        <a href="#">
            <div class="mypageModal">
            	<i class="fa-solid fa-user"></i>
            </div>
        </a>
        <div class="mypageContent">
            <div class="row g-3 align-items-center">
	            <form name="form" method="post">
	                <div class="form-floating mb-3">
	                    <input type="email" class="form-control" id="email" placeholder="name@example.com" name="email">
	                    <label for="floatingInput">Email</label>
	                </div>
	                <div class="form-floating">
	                    <input type="password" class="form-control" id="password" placeholder="Password" name="password">
	                    <label for="floatingPassword">Password</label>
	                </div>
	                <div class="form-check">
	                    <input class="form-check-input" type="checkbox" value="1" id="accountSave">
	                    <label class="form-check-label" for="flexCheckDefault">
	                        계정을 저장합니다
	                    </label>
	                </div>
	                <c:choose>
	                	<c:when test="${not empty sessionId }">
	                		sessionId: <c:out value="${sessionId }"/>
	                		<button type="button" class="btn btn-primary" id="btnLogout">LOGOUT</button>
	                	</c:when>
	                	<c:otherwise>
	                		<button type="button" class="btn btn-primary" id="btnLogin">LOGIN</button>
	                		<br>
	                	</c:otherwise>
	                </c:choose>
	                
	            </form>
                <a href="mymusicSignup"><button type="button" class="btn btn-info" id="signinBtn">SIGN UP</button></a>
            </div>
        </div>
    </div>
    <script type="text/javascript">
	    $("#btnLogin").on("click", function(){
	    	
	    	if(validation() == false) return false;
	    	
	    	$.ajax({
	    		async: true 
	    		,cache: false
	    		,type: "post"
	    		/* ,dataType:"json" */
	    		,url: "/loginProc"
	    		/* ,data : $("#formLogin").serialize() */
	    		,data : { "email" : $("#email").val(),
	    			"password" : $("#password").val()}
	    		,success: function(response) {
	    			if(response.rt == "success") {
	    				alert(response.rtMyMusic.nickname);
	    				location.href = "/mymusic";
	    			} else {
	    				alert("잘못된 회원 정보입니다.");
	    			}
	    		}
	    		,error : function(jqXHR, textStatus, errorThrown){
	    			alert("ajaxUpdate " + jqXHR.textStatus + " : " + jqXHR.errorThrown);
	    		}
	    	});
	    });
	    
	    
		$("#btnLogout").on("click", function(){
			$.ajax({
	    		async: true 
	    		,cache: false
	    		,type: "post"
	    		/* ,dataType:"json" */
	    		,url: "/logoutProc"
	    		/* ,data : $("#formLogin").serialize() */
	    		,data : { }
	    		,success: function(response) {
	    				location.href = "/mymusic";
	    		}
	    		
	    		,error : function(jqXHR, textStatus, errorThrown){
	    			alert("ajaxUpdate " + jqXHR.textStatus + " : " + jqXHR.errorThrown);
	    		}
	    	});
		});
	    
		
	
	
	    validation = function() {
//	    	if(!checkNull($("#email"), $.trim($("#email").val()), "아이디를 입력해 주세요!")) return false;
//	    	if(!checkNull($("#password"), $.trim($("#password").val()), "비밀번호를 입력해 주세요!")) return false;
	    } 
    </script>
</body>
</html>