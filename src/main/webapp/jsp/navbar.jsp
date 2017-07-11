<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<header class="navbar navbar-inverse" role="banner">
	<div class="navbar-header">
		<button class="navbar-toggle" type="button" data-toggle="collapse"
			id="menu-toggler">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index.do"><img src="<%=request.getContextPath()%>/public/img/logo.png"></a>
	</div>
	<ul class="nav navbar-nav pull-right hidden-xs">
		
		<li class="notification-dropdown hidden-xs hidden-sm">
			<a href="#" class="trigger"> 
				<i class="icon-envelope"></i>
				<span class="count">1</span>
			</a>
			<div class="pop-dialog">
				<div class="pointer right">
					<div class="arrow"></div>
					<div class="arrow_border"></div>
				</div>
				<div class="body">
					<a href="#" class="close-icon"><i class="icon-remove-sign"></i></a>
					<div class="messages">
						<a href="#" class="item"> 
							<img src="<%=request.getContextPath()%>/public/img/contact-img.png" class="display" />
							<div class="name">DEMO</div>
							<div class="msg">回家来吃饭了.</div> 
								<span class="time"><i class="icon-time"></i> 13分钟前.</span>
						</a>
						<div class="footer">
							<a href="#" class="logout">查看所有消息</a>
						</div>
					</div>
				</div>
			</div></li>
	</ul>
</header>