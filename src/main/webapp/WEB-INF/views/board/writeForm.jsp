<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="../css/table.css">

<CENTER>
	<B><FONT size="6" color="gray">글쓰기</FONT></B>
	<br /><br />
<FORM action="writePro.bo" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${num}">
	<input type="hidden" name="ref" value="${ref}">
	<input type="hidden" name="re_step" value="${re_step}">
	<input type="hidden" name="re_level" value="${re_level}">
	<TABLE class="tab_3">
		<TR>
			<TD width="40%" class="td_1"><DIV class="div_1">작성자</DIV></TD>
			<TD class="td_1" align="left">
				<DIV class="div_1">${sessionScope.sid}</DIV>
				<input type="hidden" name="writer" value="${sessionScope.sid}">
			</TD>
		</TR>
		<TR>
			<TD class="td_1"><DIV class="div_1">글제목</DIV></TD>
			<TD class="td_1" align="left">
			<c:if test="${num == 0}">	<!-- 새 글일 경우 -->
				<input type="text" name="title" maxlength="40" size="38"		/>
			</c:if>
			<c:if test="${num > 0}">	<!-- 답글일 경우 -->
				<input type="text" name="title" maxlength="40" size="38" value="[답글] "		/>
			</c:if>
			</TD>
		</TR>
		<TR>
			<TD class="td_1"><DIV class="div_1">파일첨부</DIV></TD>
			<TD class="td_1" align="left">
				<input type="file" name="img"			/>
			</TD>
		</TR>
		<TR>
			<TD class="td_1"><DIV class="div_1">글내용</DIV></TD>
			<TD class="td_1" align="left">
				<textarea name="content" rows="13" cols="40"></textarea>
			</TD>
		</TR>
		<TR>
			<TD class="td_1"><DIV class="div_1">비밀번호</DIV></TD>
			<TD class="td_1" align="left">
				<input type="password" name="passwd" maxlength="12" size="7"	/>
			</TD>
		</TR>
		<TR>
			<TD class="td_1" colspan="2">
				<BUTTON type="reset" class="btn_1">다시작성</BUTTON>
				<BUTTON type="submit" class="btn_1">작성하기</BUTTON>
				<BUTTON type="button" class="btn_1" onclick="location.href='list.bo'">메인으로</BUTTON>
			</TD>
		</TR>
	</TABLE>
</FORM>
</CENTER>