<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">

// id pwd 체크 함수
	$(function(){
		$("#check_user").click(function() {
			var input_id = $("input[name='user_id']").val();
			var input_pwd = $("input[name='user_pwd']").val();
			if(!input_id&&input_pwd){
				alert("Id와 비밀번호를 입력해주세요");
				return false;
			}else{
				$.ajax({
					type: 'post',
					url: "${pageContext.request.contextPath}/mypage/withdrawal.do",
					data: {
						'id_mem':$('#user_id').val(),
						'pwd_mem':$('#user_pwd').val()
					},
					success: function(data){
						alert(data.result)
						if(data.result == '1'){
							alert("확인 되었습니다.");
							$('#user_id').val('');
							$('#user_pwd').val('');
						}else{
							alert("ID와 비밀번호를 정확하게 입력해주세요.");
							$('#intro_mem').attr('readonly', false);
							$('#email_mem').attr('readonly', false);
						} } }) }  }) })

//계정 삭제처리
	$(function(){
		$("#delete").click(function() {
				$.ajax({
					type: 'post',
					url: "${pageContext.request.contextPath}/mypage/checkidpwd.do",
					data: {
						'id_mem':$('#user_id').val(),
						'pwd_mem':$('#user_pwd').val()
					},
					success: function(data){
						alert(data.result)
						if(data.result == '1'){
							alert("확인 되었습니다.");
							$('#user_id').val('');
							$('#user_pwd').val('');
						}else{
							alert("ID와 비밀번호를 정확하게 입력해주세요.");
							$('#intro_mem').attr('readonly', false);
							$('#email_mem').attr('readonly', false);
						} } }) }) })	
	
						
						
						
						
						
						
						
						
						
						
</script>
<div class=myprobox>
	<br> <span>◆</span><span> 계정 삭제 </span><span>◆</span><br>
	<hr>
	<!-- 인사 -->
	<span>안녕하세요, <span>${id.name_mem}</span>님!
	</span><br>
	<p>원하는 목표를 이루셨나요?</p>
	<p>CamTudy와 함께한 시간이 도움이 되셨으면 좋겠습니다.</p>
	<p>다음번 Study에도 CamTudy를 기억해주세요!</p>
	<br> <br>

	<!-- Notice -->
	<span> Notice </span>
	<p>가입하신 모든 그룹에서 탈퇴를 하셨나요?</p>
	<p>모두 탈퇴하셔야 정상적인 계정 삭제가 이루어집니다.</p>
	<br><br>
	<!-- 정보 변경 전 본인 확인 -->

		<span> Step. 1 </span>
		<p>본인 확인을 위해 ID와 비밀번호를 입력해주세요</p>
		<p>ID :</p>
		<input type="text" id="user_id" name="user_id"><br> <br>
		<p>비밀번호 :</p>
		<input type="text" id="user_pwd" name="user_pwd"><br> <br>
		<input type="button" id="check_user" name="check_user" value="확인" ><br><br>
		
		
		<span> Step. 2 </span>
		<p>계정 삭제 버튼을 눌러주세요</p>
		<input type="button" id="delete" name="delete" value="계정삭제" ><br><br>
	<br>
</div>
