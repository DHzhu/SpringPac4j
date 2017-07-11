<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<script type="text/javascript">
	var showPage = function(pageUrl){
		$.ajax({
    		type:"get",
    		url:pageUrl,
    		dataType:"html",
    		timeout: 30000,
        	success:function(data){
        		$("#pageContent").empty();
        		$("#pageContent").append(data);
        	},
        	error:function(XMLHttpRequest, textStatus, errorThrown){
        		
        	}
        });
	};
	
	$(function(){
		$("#dashboard-menu >li >a.vmenu").click(function(){
			$("#dashboard-menu li").removeClass("active");
			$(this).parent().addClass("active");
			$("#dashboard-menu >li >ul.submenu").css("display","none");
		});
		
		$("#dashboard-menu >li >ul.submenu a.vmenu").click(function(){
			$("#dashboard-menu li").removeClass("active");
			$(this).addClass("active");
			$(this).parent().parent().addClass("active");
			$(this).parent().parent().parent().addClass("active");
		});
	});

</script>
<div id="sidebar-nav">
	<ul id="dashboard-menu">
		<li class="active">
			<div class="pointer">
				<div class="arrow"></div>
				<div class="arrow_border"></div>
			</div> <a href="index.do" class="vmenu"> <i class="icon-home"></i> <span>首页</span>
		</a>
		</li>
		<li>
			<a class="dropdown-toggle" href="#"> 
				<i class="icon-group"></i> <span>测试页面</span> <i class="icon-chevron-down"></i>
			</a>
			<ul class="submenu">
				<li><a class="vmenu" href="#" onclick="showPage('logPage.do')">日志输出</a></li>
			</ul>
		</li>

		<li>
			<a class="vmenu" href="#" onclick="showPage('client.do')"> 
				<i class="icon-calendar-empty"></i>
				<span>测试2</span>
			</a>
		</li>
	</ul>
</div>