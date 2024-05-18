<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${result == 1}">
	<script>
		alert("수정 되었습니다.");
		location.href="main.me";
	</script>
</c:if>

<c:if test="${result != 1}">
	<script>
		alert("수정되지 않았습니다.");
		history.go(-1);
	</script>
</c:if>