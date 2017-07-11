<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<jsp:directive.include file="include.jsp" />

<link href="<%=request.getContextPath()%>/public/css/compiled/index.css" rel="stylesheet" type="text/css" media="screen" />

<title>首页</title>
</head>

<body>
	<!-- navbar start -->
	<jsp:directive.include file="navbar.jsp" />
	<!-- navbar end -->
	
	<!-- sidebar start -->
	<jsp:directive.include file="sidebar.jsp" />
	<!-- sidebar end -->
	
	<!-- main container -->
    <div class="content" id="pageContent">
    	
    </div>
</body>
</html>