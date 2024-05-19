<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/table.css"	/>

<CENTER>
	<B><FONT size="6" color="darkgray">메인</FONT></B>

<br /><br />

<TABLE style="width: 40%; height: 20%;" class="tab_2">
	<TR>
		<TD>
		<c:if test="${sessionScope.sid == null}">
			<BUTTON onclick="location.href='loginForm.me'" class="btn_1">로그인</BUTTON>
			<BUTTON onclick="location.href='../board/list.bo'" class="btn_1">게시판</BUTTON>
		</c:if>
		<c:if test="${sessionScope.sid != null}">
			<H3><B><SPAN class="span_2">[${sessionScope.sid}]님 환영합니다!</SPAN></B></H3>
			<br />
			<BUTTON onclick="location.href='updateForm.me'" class="btn_1">정보수정</BUTTON>
			<BUTTON onclick="location.href='deleteForm.me'" class="btn_1">회원탈퇴</BUTTON>
			<BUTTON onclick="location.href='../board/list.bo'" class="btn_1">게시판</BUTTON>
			<BUTTON onclick="location.href='../board/myList.bo'" class="btn_1">내글목록</BUTTON>
			<BUTTON onclick="location.href='logout.me'" class="btn_1">로그아웃</BUTTON>
		</c:if>
		</TD>
	</TR>
</TABLE>
</CENTER>