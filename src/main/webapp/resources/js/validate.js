ttest = function(){
	alert("wow");
}

validationUpdt = function(){
	       xyy = /^[a-z0-9_-]{2, 10}$/;
	       
	       if(xyy.test($.trim($("#name").val())) == false) {
	    	   alert("실패");
	    	   $("#name").focus();
	    	   return false;
	       } else{
//	    	   by pass
	       }
	    	
} 