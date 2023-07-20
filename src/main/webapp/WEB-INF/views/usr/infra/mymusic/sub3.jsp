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
                <a href="../index.html"><button class="btn btn-secondary" type="button">Main</button></a>
                <a href="sub01.html"><button class="btn btn-secondary" type="button">AI</button></a>
                <a href="sub02.html"><button class="btn btn-secondary" type="button">Write</button></a>
                <a href="#"><button class="btn btn-secondary" type="button">Notice</button></a>
            </div>
        </div>  
    </header>
    <div class="container">
        <div class="sub02Container">
            <select class="form-select" aria-label="Default select example">
                <option value="1" selected>요청</option>
                <option value="2">업로드</option>
                <option value="3">후기</option>
            </select>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>seq</th>
                        <th>title</th>
                        <th>writer</th>
                        <th>date</th>
                        <th>view</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th>1</th>
                        <th><a href="#">우와 신나요</a></th>
                        <th>Romero</th>
                        <th>2023. 06. 21.</th>
                        <th>2</th>
                    </tr>
                    <tr>
                        <th>2</th>
                        <th><a href="#">집에가고싶다</a></th>
                        <th>Hojoong</th>
                        <th>2023. 06. 22.</th>
                        <th>1</th>
                    </tr>
                    <tr>
                        <th>3</th>
                        <th><a href="#">락앤롤~~</a></th>
                        <th>Jongweon</th>
                        <th>2023. 06. 27.</th>
                        <th>8</th>
                    </tr>
                </tbody>
            </table>
            <a href="mymusicWrite"><button type="button" class="btn btn-primary" id="writeBtn">글쓰기</button></a>
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
                <div class="form-floating mb-3">
                    <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                    <label for="floatingInput">Email</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Password</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="1" id="accountSave">
                    <label class="form-check-label" for="flexCheckDefault">
                        계정을 저장합니다
                    </label>
                </div>
                <button type="button" class="btn btn-primary" id="loginBtn">LOGIN</button>
                <button type="button" class="btn btn-info" id="signinBtn">SIGN IN</button>
            </div>
        </div>
    </div>
</body>
</html>