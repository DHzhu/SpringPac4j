$.ajaxSetup({
    async: true,
    global: false,
    complete:function(XMLHttpRequest,textStatus){
    	try{
    		var info = jQuery.parseJSON(XMLHttpRequest.responseText);
            if(info.success == false && info.msg == "timeout"){
            	window.location.href = 'index.do';
            }
    	}catch(e){
    		
    	}
    }
});
var Container = function(isPagination, tableId) {
	var object = new Object;
	object.isPagination = isPagination;
    object.tableId = tableId;
    object.headAarry;
    object.params;
    object.url;
    object.error = null;
    
    object.showInfo = function(headers,params,url) {
    	object.headAarry = headers;
    	object.params = params;
    	object.url = url;
        if (headers == null || headers == undefined || headers.length == 0) {
            return
        };
        object.getAjaxInfo(url, params);
    }
    
    object.render = function(data){
    	$("#" + object.tableId + " tbody").empty();
    	var result = data.dataList;
    	var html = "";
    	for(var i = 0; i < result.length ; i++){
			html += "<tr>";
			var heads = object.headAarry;
			for(var j = 0; j < heads.length; j++){
				html += "<td class='" + heads[j].classes + "'>";
				if((typeof heads[j].formatter) == "function"){
					html += heads[j].formatter(result[i]);
				}else{
					html += $.trim(result[i][heads[j].code]);
				}
				html += "</td>";
			}	
			html += "</tr>"
		}
    	$("#" + object.tableId + " tbody").append(html);
    	if(object.isPagination && data.pages > 0){
    		var options = {
				currentPage: data.pageNo,
				totalPages: data.pages,
				numberOfPages: 5,
				total: data.total,
				onPageClicked:function(event, originalEvent, type, page){
					var params = object.params;
					var url = object.url;
					params.pageNo = page;
					object.getAjaxInfo(url, params);
				}
			}
			$("#staticPage").bootstrapPaginator(options);
    		
    		$("#pageGoBtn").bind("click",function(){
    			var gotoPage = $("#pageGoInput").val().replace(/\D/g,'');
    			if(gotoPage == null || gotoPage == "") return;
    			
    			var totalPage = data.pages;
    			gotoPage = gotoPage < 1 ? 1 : gotoPage;
    			gotoPage = gotoPage > totalPage ? totalPage : gotoPage;
    			var params = object.params;
				params.pageNo = gotoPage;
				object.getAjaxInfo(object.url, params);
    		});
    		$("#pageGoInput").bind("keypress",function(e){
    			var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
    			if (eCode == 13){
    				$("#pageGoBtn").trigger("click");
    			}
    		});
    	}
    }
    
    object.getAjaxInfo = function(url,params){
    	$.ajax({
    		type:"post",
    		url:url + "?" + Math.floor(Math.random() * (100000 + 1)),
    		data:params,
    		dataType:"json",
    		timeout: 30000,
        	success:function(data){
        		if(data.success == false) return;
        		object.render(data);
        	},
        	error:function(XMLHttpRequest, textStatus, errorThrown){
        		object.error;
        	}});
    }
    
    return object;
}
