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
                <a href="sub01.html"><button class="btn btn-secondary" type="button">AI</button></a>
                <a href="sub02.html"><button class="btn btn-secondary" type="button">Write</button></a>
                <a href="sub03.html"><button class="btn btn-secondary" type="button">Notice</button></a>
            </div>
        </div>  
    </header>
    <div class="container">
        <div class="main">
            <form name="form" method="post">
                <div class="row g-3">
                    <div class="col-auto mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" placeholder="name" class="form-control" id="name" name="name">
                    </div> 
                    <div class="col-auto mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" placeholder="email@email.ema" class="form-control" id="email" name="email">
                    </div>
                </div>
                <div class="row g-3 ">
                    <div class="col-auto mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" placeholder="8~16 eng and num" class="form-control" id="password" name="password">
                    </div>
                    <div class="col-auto mb-3">
                        <label for="nickname" class="form-label">Nickname</label>
                        <input type="text" placeholder="nickname" class="form-control" id="nickname" name="nickname">
                    </div>
                </div>
                <div class="row g-3">
                    <div class="col-auto mb-3">
                        <label for="phone" class="form-label">Phone</label>
                        <input type="text" placeholder="000-0000-0000" class="form-control" id="phone" name="phone">
                    </div>
                    <div class="col-auto mb-3">
                        <label for="dob" class="form-label">Birthday</label>
                        <input type="text" placeholder="YYYYMMDD" class="form-control" id="dob" name="dob">
                    </div>
                </div>
            </form>
        </div>
        <div class="d-grid gap-2 col-6 mx-auto">
            <button class="btn btn-primary" id="signInBtn" type="button">회원가입</button>
        </div>
    </div>
	<script src="../../../../resources/js/validate.js"></script>
    <script type="text/javascript">
      
	    var objNick = $("#nickname");
		validationNick = function() {
			console.log(objNick.val());
			if (nickCheck(objNick) == false)
				return false;
		}
		
		var objPw = $("#password");
		validationPw = function(){
			console.log(objPw.val());
			if(pwCheck(objPw) == false)
				return false;
		}
		
		var objEmail = $("#email");
		validationEmail = function(){
			console.log(objEmail.val());
			if(emailCheck(objEmail) == false)
				return false;
		}
			
		$("#signInBtn").on("click", function(){
			if (validationNick() == false)
				return false;
			if (validationPw() == false)
				return false;
			if (validationEmail() == false)
				return false;
	         //$("form[name=formList]").attr("action", "get");
	         $("form[name=form]").attr("action", "/myMusicInsert").submit();
	         
		});   
      
      
   
   </script>
</body>
</html>