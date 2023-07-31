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
    <style>
    	li{
    		list-style: none;
    	}
    </style>
</head>
<body>
    <header>
        <div class="btnContainer">
            <div class="d-grid gap-2 d-md-block">
                <a href="mymusic"><button class="btn btn-secondary" type="button">Main</button></a>
                <a href="mymusicAi"><button class="btn btn-secondary" type="button">MusicAI</button></a>
                <a href="myMusicNoticeList"><button class="btn btn-secondary" type="button">Request</button></a>
                <a href="myMusicUploadList"><button class="btn btn-secondary" type="button">Upload</button></a>
            </div>
        </div>  
    </header>
    <div class="container">
        <div class="sub02Container">
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
                <c:choose>
                	<c:when test="${fn:length(list) eq 0}">
                		등록된 게시글이 없습니다.
                	</c:when>
                	<c:otherwise>
	                	<c:forEach items="${list}" var="list" varStatus="status">
			                <tbody>
			                    <tr>
			                        <th><c:out value="${list.seq}"/></th>
			                        <th><a href="myMusicNoticeView?seq=<c:out value='${list.seq }'/>"><c:out value="${list.header }"/></a></th>
			                        <th><c:out value="${list.writer }"/></th>
			                        <th><c:out value="${list.date }"/></th>
			                        <th><c:out value="${list.number }"/></th>
			                    </tr>
			                </tbody>	
		                </c:forEach>
	                </c:otherwise>
                </c:choose>
            </table>
            
            <c:if test="${vo.startPage gt vo.pageNumToShow}">
					  <ul class="pagination">
					    <li class="page-item">
					      <a class="page-link" href="#" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    <li class="page-item"><a class="page-link" href="javascript:goList(${vo.startPage - 1})">1</a></li>
					    <li class="page-item">
					      <a class="page-link" href="#" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					  </ul>
					  <a class="page-link" href="javascript:goList(${i.index})">${i.index}</a>
                      </c:if>
                      <ul class="pagination">
                      	<c:forEach begin="${vo.startPage}" end="${vo.endPage}" varStatus="i">
							<c:choose>
								<c:when test="${i.index eq vo.thisPage}">
						                <li class="page-item active"><a class="page-link" href="javascript:goList(${i.index})">${i.index}</a></li>
								</c:when>
								<c:otherwise>             
						                <li class="page-item"><a class="page-link" href="javascript:goList(${i.index})">${i.index}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>     
						<c:if test="${vo.endPage ne vo.totalPages}">                
						                <li class="page-item"><a class="page-link" href="javascript:goList(${vo.endPage + 1})"><i class="fa-solid fa-angle-right"></i></a></li>
						</c:if>   
					  </ul>        
             <form name="formList" method="get"><!-- post-get 간 변경 가능 -->
	            <input type="hidden" name="thisPage" value="<c:out value="${vo.thisPage}" default="1"/>">
				<input type="hidden" name="rowNumToShow" value="<c:out value="${vo.rowNumToShow}"/>">
		          <!-- 
		          <select class="form-select" aria-label="typeSelect" name="shOption">
		             <option value="1">제목</option>
		          </select>
		           -->
		          <div id="searchBox">
		             <label class="form-label"></label>
		             <input type="text" class="form-control" id="searchForm" aria-describedby="searchForm" name="shKeyword" placeholder="search" value="<c:out value="${vo. shKeyword }"/>" >
		          </div>
		          <div class="d-flex p-2 justify-content-sm-between">
		          	<button type="button" class="btn btn-primary" id="btnSubmit">Submit</button>
				  	<button type="button" class="btn btn-primary" id="writeBtn">글쓰기</button>
				  </div>
		       </form>
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
	            	<c:choose>
		            	<c:when test="${empty sessionId }">
		                <div class="form-floating mb-3">
		                    <input type="email" class="form-control" id="email" placeholder="name@example.com" name="email" value="admin@admin.com">
		                    <label for="floatingInput">Email</label>
		                </div>
		                <div class="form-floating">
		                    <input type="password" class="form-control" id="password" placeholder="Password" name="password" value="admin0119">
		                    <label for="floatingPassword">Password</label>
		                </div>
		                <div class="form-check">
		                    <input class="form-check-input" type="checkbox" value="1" id="accountSave">
		                    <label class="form-check-label" for="flexCheckDefault">
		                        계정을 저장합니다
		                    </label>
		                </div>
		                </c:when>
	                </c:choose>
	                <c:choose>
	                	<c:when test="${not empty sessionId }">
	                		sessionId: <c:out value="${sessionId }"/>
	                		<button type="button" class="btn btn-primary" id="btnLogout">LOGOUT</button>
	                	</c:when>
	                	<c:otherwise>
	                		<button type="button" class="btn btn-primary" id="btnLogin">LOGIN</button>
	                		<br>
                			<a href="mymusicSignup"><button type="button" class="btn btn-info" id="signinBtn">SIGN UP</button></a>
	                	</c:otherwise>
	                </c:choose>
	                
	            </form>
            </div>
        </div>
    </div>
    <script>
	    $("#btnSubmit").on("click", function(){
	        
	        $("form[name=formList]").attr("method", "get");
	        $("form[name=formList]").attr("action", "/myMusicNoticeList").submit();
	        
	        
	     });
	     
	     $("#writeBtn").on("click", function(){
	    	window.location.href="/mymusicNoticeInsertPage";
	     });
	     
	     goList = function(thisPage) {
	 		$("input:hidden[name=thisPage]").val(thisPage);
	 		$("form[name=formList]").attr("action", "/myMusicNoticeList").submit();
	     }
	     
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
//		    	if(!checkNull($("#email"), $.trim($("#email").val()), "아이디를 입력해 주세요!")) return false;
//		    	if(!checkNull($("#password"), $.trim($("#password").val()), "비밀번호를 입력해 주세요!")) return false;
		    } 
    </script>
</body>
</html>