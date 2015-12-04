<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
 
<script>

$(function() {
  $( "#date_start_study ,#date_end_study" ).datepicker({
    dateFormat: 'yy-mm-dd',
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    dayNames: ['일','월','화','수','목','금','토'],
    dayNamesShort: ['일','월','화','수','목','금','토'],
    dayNamesMin: ['일','월','화','수','목','금','토'],
    showMonthAfterYear: true,
    yearSuffix: '년'
  });
});
</script>

<form action="${pageContext.request.contextPath}/studyroom/makestudy.do" method="post">
▶ name : 
<input  name="name_study" id="name_study" type="text">
<hr>

▶ Category : 
<select name="category_study" id="category_study">
	<c:forEach items="${categorylist}" var="array">
		<option value="${array.name_category}">${array.name_category}</option>
	</c:forEach>
</select>
<hr>

▶ 인원수 : 
<select name="num_mem_max_study" id="num_mem_max_study">
	<c:forEach var="i" begin="1" end="8" step="1">								
	<option value="${i}">${i} 명</option>
</c:forEach>
</select>
<hr>

▶ Plan : <br>
- 기간: <input type="text" name="date_start_study" id="date_start_study"> 
~ 
<input type="text" name="date_end_study" id="date_end_study"> <br>
- 시간: 
<select name="time_start_study">
	<c:forEach var="i" begin="1" end="24" step="1">								
	<option value="${i}">${i} 시</option>
</c:forEach>
</select>
~
<select name="time_end_study">
	<c:forEach var="i" begin="1" end="24" step="1">								
	<option value="${i}">${i} 시</option>
</c:forEach>
</select>
(24시간 기준)

<hr>
▶ 벌점 : (초기 Point 100점) <br>
- 지각 시간:
<select name="latness_time_study">
	<option value="5">5분</option>
	<option value="15">15분</option>
	<option value="30">30분</option>
</select>
<br>
- 지각 벌점:
<select name="lateness_panalty_study">
	<c:forEach var="i" begin="5" end="30" step="5">								
	<option value="${i}">${i} 점</option>
</c:forEach>
</select>
<br>
- 결석 벌점:
<select name="absence_panalty_study">
	<c:forEach var="i" begin="10" end="50" step="10">								
	<option value="${i}">${i} 점</option>
</c:forEach>
</select>
<hr>

▶ 공지사항 : <br>
<textarea  name="notice_study" rows="10" cols="60" ></textarea>

<input type="submit" value="생성">
</form>