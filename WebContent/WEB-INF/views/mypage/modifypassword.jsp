<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	
		//비밀번호 확인
		$(function () {
			$("#check_pwd").click(function() {
				var input_value = $("input[name='user_pwd']").val();
				if(!input_value){
					alert("현재 비밀번호를 입력하세요");
					$("input[name='user_pwd']").focus();
					return false;
				}else{
					$.ajax({
						type: 'post',
						url: "${pageContext.request.contextPath}/mypage/modifypassword.do",
						data: {
							'pwd_mem':$('#user_pwd').val()
						},
					      success: function(data){
					    	  alert(data.result)
					    	  if(data.result == '1'){
					    		alert("확인되었습니다. 수정 할 비밀 번호를 입력해 주세요^^");
					    		$("input[name='user_pwd']").val('');
					    		$("input[name='pwd_update']").focus();
					    		
					    	  }else{
					    		  alert("비밀번호가 틀립니다.");
						          $("input[name='user_pwd']").val('');
					    	  }
					      },
					      error:function(xhr,status,error){ //ajax 오류인경우  
					            alert("error\nxhr : " + xhr + ", status : " + status + ", error : " + error);                 
					    }  })  }  })  })
				
		//비밀번호 수정 
		 $(function() {
			$("#update").click(function() {
				var input_value = $("input[name='pwd_update']").val();
				
				if(!input_value){
					alert("수정 할 비밀번호를 입력하세요");
					$("input[name='pwd_update']").focus();
				}else{
					$.ajax({
						type: 'post',
						url: "${pageContext.request.contextPath}/mypage/updatepassword.do",
						data: {
							'pwd_mem':$('#pwd_update').val()
						},
					      success: function(data){
					    	  alert(data.result);
					    	  if(data.result == '0'){
					    		  alert("같은 비밀번호를 입력하셨습니다.");
					    		  $("input[name='pwd_update']").val('');
					    		  $("input[name='pwd_update']").focus();
					    	  }else{
					    	  alert("수정되었습니다.");
					    	  $("input[name='pwd_update']").val('');
					    	}
					      },
					      error:function(xhr,status,error){ //ajax 오류인경우
					            alert("error\nxhr : " + xhr + ", status : " + status + ", error : " + error);                 
					    }  })  }  })  })
		
 	
</script>

<div class=myprobox>
	<span>★</span> 비밀번호 수정하기 <span>★</span><br>

	<!-- 수정불가 정보 -->
	<p>ID : ${pwd.id_mem}</p>
	<p>이름 : ${pwd.name_mem}</p>

	<!-- 정보 변경 전 본인 확인 -->
	<form
		action="${pageContext.request.contextPath}/mypage/modifypassword.do"
		method="post">
		<p>현재 비밀번호</p>
		<input type="text" id="user_pwd" name="user_pwd"><br> <br>
		<input type="button" id="check_pwd" name="check_pwd" value="확인">
	</form>
	<br>

	<!-- 비밀번호 수정 -->
	<form
		action="${pageContext.request.contextPath}/mypage/updatepassword.do"
		method="post">
	<p>수정 할 비밀번호</p>
	<input type="text" id="pwd_update" name="pwd_update"><br>
	<br> <input type="button" id="update" name="update" value="확인">
	</form>
</div>





