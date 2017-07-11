var utils = {};

//提交ajax请求
utils.postAjax = function(url,params,succ){
	$.ajax({
		type:"post",
		url:url,
		data:params,
		dataType:"json",
		contentType:"application/json;charset=UTF-8",
		timeout: 30000,
    	success:succ
    });
};
