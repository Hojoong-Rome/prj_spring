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



nickCheck = function(obj){
	aaa = /^[가-힇a-z0-9]{2,10}$/;
	
	if(aaa.text($.trim(obj.val())) == false){
		$("#nickname").focus();
		return false;
	}else{
		// bypass
	}
}

pwCheck = function(obj){
	bbb = /^[a-z0-9]{2,14}$/;
	
	if(bbb.text($.trim(obj.val())) == false){
		$("#password").focus();
		return false;
	}else{
		// bypass
	}
}

emailCheck = function(obj){
	ccc = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/
	
	if(ccc.text($.trim(obj.val())) == false){
		$("#email").focus();
		return false;
	}else{
		// bypass
	}
}