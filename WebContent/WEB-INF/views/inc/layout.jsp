<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
	<!-- title 영역 -->
	<tiles:getAsString name="title"/>
</title>
</head>
<body>

	<!-- Header -->
	<div id="header" style="background-color: gray;">
	<tiles:insertAttribute name="header"/>
	</div>
	
	<!-- Navi -->
	<div id="navi" style="width:500px; float: left; background-color: yellow;">
			<tiles:insertAttribute name="navi"/>
	</div>	
	
	<!-- content -->
	<div id="content" style="float: left; background-color: orange;">
			<tiles:insertAttribute name="content"/>
	</div>
	
</body>
</html>