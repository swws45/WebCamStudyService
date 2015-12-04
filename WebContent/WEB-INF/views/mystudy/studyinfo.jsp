<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
▶ 총 누적 공부 시간: ${time_total} 시간 <br>

▶ Study별 공부 시간 <br>
<table border="1"  style="border-collapse:collapse; border:1px gray solid; text-align: center;">
<tr>
<td>Study</td><td>관리자</td><td>Category</td><td>Point</td>
<td>지각</td><td>결석</td><td>공부 시간</td><td>시작일</td><td>Dday</td>
</tr>
<c:forEach items="${list}" var="array">
<tr>
<td>${array.name_study}</td><td>${array.manager_id_study}</td>
<td>${array.category_study}</td><td>${array.point_list} p</td><td>${array.latness} 회</td><td>${array.absence} 회</td>
<td>${array.acc_time_list} h</td><td>${array.date_start_study}</td><td> -${array.d_day}일</td>
</tr>
</c:forEach>
</table>