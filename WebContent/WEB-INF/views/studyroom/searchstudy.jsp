<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(function() {
$("#search").click(function () {
	$.ajax(
			{       
					type: "post",
					url : "${pageContext.request.contextPath}/studyroom/searchstudyjson.do",
					data: {
						column:$("#select").val(),
						keyword: $("#keyword").val()
					},
					success : function(data,status){
							var output="";
							output +="<tr>";
							output +="<td>번호</td><td>제목</td><td>관리자</td><td>카테고리</td><td>인원</td>";
							output +="<td>인원 제한</td><td>시작일</td><td>종료일</td><td>시간</td>";
							output +="<td>지각벌점</td><td>지각시간</td><td>결석벌점</td><td>공지</td>";
							output +="</tr>";
						$.each(data.list, function(index, value) {
							output +="<tr>"
							output +="<td>"+this.no_study+"</td><td>"+this.name_study+"</td><td>"+this.manager_id_study+"</td><td>"+this.category_study+"</td>";
							output +="<td>"+this.numberofmem_study+ "명</td><td>"+this.maxmember_study+ "명</td><td>"+this.date_start_study+"</td>";
							output +="<td>"+this.date_end_study+"</td><td>"+this.time_start_study+" ~ "+this.time_end_study+"</td><td>"+this.lateness_panalty_study+"</td>";
							output +="<td>"+this.latness_time_study+"</td><td>"+this.absence_panalty_study+"</td><td>"+this.notice_study+"</td>";
							output +="</tr>";
							});
							$('#display').empty();
							$('#display').append(output);
						},
					error : function(xhr){ alert(xhr.status); }
			}		
		);
});
})
</script>

<select id="select">
	<option value="name_study">제목</option>
	<option value="manager_id_study">관리자</option>
	<option value="category_study">카테고리</option>
</select>
<input type="text" name="keyword" id="keyword" size="20">
<input type="button" value="검색" id="search">

<table id="display">
		<tr>
		<td>번호</td><td>제목</td><td>관리자</td><td>카테고리</td><td>인원</td>
		<td>인원 제한</td><td>시작일</td><td>종료일</td><td>시간</td>
		<td>지각벌점</td><td>지각시간</td><td>결석벌점</td><td>공지</td>
		</tr>
<c:forEach items="${studylist}" var="array">
		<tr>
		<td>${array.no_study}</td><td>${array.name_study}</td><td>${array.manager_id_study}</td><td>${array.category_study}</td>
		<td>${array.numberofmem_study} 명</td><td>${array.maxmember_study} 명</td><td>${array.date_start_study}</td>
		<td>${array.date_end_study}</td><td>${array.time_start_study} ~ ${array.time_end_study}</td><td>${array.lateness_panalty_study}</td>
		<td>${array.latness_time_study}</td><td>${array.absence_panalty_study}</td><td>${array.notice_study}</td>
		</tr>
	</c:forEach>
</table>