<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">

	//정보 수정 요청 보내기
	function changeStat() {
		alert("정보수정요청");
		$("input[name='email_mem']").focus();
		$('#intro_mem').attr('readonly', false);
		$('#email_mem').attr('readonly', false);
	}
	
	//정보 수정
	$(function() {
		$("#btn_update").click(function() {
			alert("ajax 입장")
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/mypage/myprofile.do",
				data : {
					'email_mem' : $('#email_mem').val(),
					'intro_mem' : $('#intro_mem').val()
				},
				success : function(data) {
					alert(data.result)
			    	  if(data.result == '1'){
			    		alert("수정되었습니다.");
			    		
			    	  }else{
			    		  alert("수정된 정보가 없습니다.");
				          $("input[name='email_mem']").focus();
			    	  }
			      },
			      error:function(xhr,status,error){ //ajax 오류인경우  
			            alert("error\nxhr : " + xhr + ", status : " + status + ", error : " + error);                 
			    }  })    })  })
</script>

<div class=myprobox>
	<span>★</span> 내 정보 <span>★</span><br>
	<div class="pro_img">프로필 이미지</div>
	<div class="pro_info">
		<p>ID : ${profile.id_mem}</p>
		<p>이름 : ${profile.name_mem}</p>

		<form action="${pageContext.request.contextPath}/mypage/myprofile.do"
			method="post">
			<input value="정보 수정" type="button" onclick="changeStat()"	class="update"><br>
			<p>E-Mail :</p>
			<input id="email_mem" name="email_mem" type="text" value="${profile.email_mem}" readonly="readonly" /> 
			<br>
			<p>자기소개 :</p>
			<input id="intro_mem" name="intro_mem" type="text" value="${profile.intro_mem}" readonly="readonly" /> 
			<br> 
			<input type="button" value="수정 완료" name="btn_update"  id="btn_update"><br>
		</form>
	</div>
</div>










