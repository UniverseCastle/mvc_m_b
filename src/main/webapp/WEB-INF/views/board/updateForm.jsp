<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="../css/table.css">

<CENTER>
	<B><FONT size="6" color="gray">회원수정</FONT></B>
	<br /><br />
<FORM action="updatePro.bo" method="post" enctype="multipart/form-data">
	<TABLE class="tab_3">
		<TR>
			<TD width="40%" class="td_1"><DIV class="div_1">작성자</DIV></TD>
			<TD class="td_1" align="left">
				<DIV class="div_1">${sessionScope.sid}</DIV>
				<input type="hidden" name="writer" value="${sessionScope.sid}"	/>
				<input type="hidden" name="num" value="${dto.num}"				/>
			</TD>
			
		</TR>
		<TR>
			<TD class="td_1"><DIV class="div_1">파일첨부</DIV></TD>
			<TD class="td_1" align="left">
				<input type="file" name="img"	/>
			</TD>
		</TR>
		<TR>
			<TD class="td_1"><DIV class="div_1">글제목</DIV></TD>
			<TD class="td_1" align="left">
				<input type="text" name="title" maxlength="40" size="38" value="${dto.title}"		/>
			</TD>
		</TR>
		<c:if test="${dto.img != null}">
		<TR>
			<TD class="td_1">이미지</TD>
			<TD class="td_1">
				<img src="../resources/upload/${dto.img}" width="50%" height="50%" class="img_1"	/>
				<input type="hidden" name="orgImg" value="${dto.img}"	/>
			</TD>
		</TR>
		</c:if>
		<TR>
			<TD class="td_1"><DIV class="div_1">글내용</DIV></TD>
			<TD class="td_1" align="left">
				<textarea name="content" rows="13" cols="40">${dto.content}</textarea>
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
				<BUTTON type="submit" class="btn_1">수정하기</BUTTON>
				<BUTTON type="button" class="btn_1" onclick="location.href='list.bo'">메인으로</BUTTON>
			</TD>
		</TR>
	</TABLE>
</FORM>
</CENTER>