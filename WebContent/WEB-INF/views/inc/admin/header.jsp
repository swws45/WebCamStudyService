<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<!-- admin header -->
	
	<header>
	<a href="${pageContext.request.contextPath}/admin.do">
		<img alt="CamTudy" src="${pageContext.request.contextPath}/img/logo.png" class="logo_img" >
	</a>
	<ul>
		<li><a
			href="${pageContext.request.contextPath }/search/searchmember.do">Search</a></li>
		<li><a
			href="${pageContext.request.contextPath }/list/memberlist.do">List</a></li>
	</ul>
	<button type="button" data-toggle="modal" data-target="#myModal"  style="width: 80px; position: fixed; right:0px; margin: 55px 25px; ">로그아웃</button>
</header>

<!-- Logout Modal -->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">LOGOUT</h4>
			</div>
			<div class="modal-body">
				<p>로그아웃 하시겠습니까?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">로그아웃</button>
			</div>
		</div>

	</div>
</div>
	