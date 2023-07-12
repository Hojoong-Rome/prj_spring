check = function(obj){
	xyy = /^[a-z0-9_-]{2,10}$/;

//	console.log(xyy.test($.trim(obj.val())));

	alert(obj.val());
	
	
	if(xyy.test($.trim(obj.val())) == false) {
		$("#name").focus();
		return false;
	} else{
//		by pass
	}
	    	
} 