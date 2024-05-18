<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${result == 1}">
	<script>
		alert("${result}개의 글이 등록되었습니다.");
		location.href="list.bo";
	</script>
</c:if>

<c:if test="${result != 1}">
	<script>
		alert("글이 등록되지 않았습니다.");
		history.go(-1);
	</script>
</c:if>