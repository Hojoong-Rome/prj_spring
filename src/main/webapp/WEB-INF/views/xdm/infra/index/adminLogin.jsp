<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="../../../../resources/adminlogin/style.css">
</head>
<body>
    <div class="container">
        <div class="main">
            <h2>
                Admin Login
            </h2>
            <div class="row g-3 align-items-center">
                <div class="col-auto">
                    <label for="inputId6" class="col-form-label"></label>
                </div>
                <div class="col-auto">
                    <input type="text" id="inputId6" class="form-control" aria-labelledby="idHelpInline" placeholder="ID">
                </div>
            </div>
            <div class="row g-3 align-items-center">
                <div class="col-auto">
                    <label for="inputPassword6" class="col-form-label"></label>
                </div>
                <div class="col-auto">
                    <input type="password" id="inputPassword6" class="form-control" aria-labelledby="passwordHelpInline" placeholder="PW">
                </div>
            </div>
            <div class="row g-3 align-items-center">
                <div class="col-auto">
                    <a href="adminPage"><button type="button" id="loginBtn" class="btn btn-info col-auto align-items-center">Login</button></a>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>