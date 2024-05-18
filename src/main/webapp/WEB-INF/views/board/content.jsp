<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="../css/table.css"	/>

<CENTER>
	<B><FONT size="6" color="darkgray">글내용</FONT></B>
	<br /><br />
<TABLE class="tab_4" style="height: 30%;">
	<TR>
		<TH class="th_1" style="width: 10%;"><DIV class="div_2">글번호</DIV></TH>
		<TH class="th_1" style="width: 10%;"><DIV class="div_1">${dto.num}</DIV></TH>
		<TH class="th_1" style="width: 10%;"><DIV class="div_2">글제목</DIV></TH>
		<TH class="th_1" style="width: 40%;"><DIV class="div_1">${dto.title}</DIV></TH>
		<TH class="th_1" style="width: 10%;"><DIV class="div_2">작성자</DIV></TH>
		<TH class="th_1" style="width: 20%;"><DIV class="div_1">${dto.writer}</DIV></TH>
	</TR>
	<TR>
		<TH class="th_1" style="width: 10%;"><DIV class="div_2">조회수</DIV></TH>
		<TH class="th_1" style="width: 7%;"><DIV class="div_1">${dto.readCount}</DIV></TH>
		<TH class="th_1" style="width: 10%;"><DIV class="div_2">작성일</DIV></TH>
		<TH class="th_1" style="width: 26%;" colspan="3"><DIV class="div_1">${dto.reg}</DIV></TH>
	
	</TR>
	<TR>
		<TD class="td_1"><DIV class="div_2">이미지</DIV></TD>
		<TD class="td_1" colspan="5">
		<c:if test="${dto.img != null}">
			<img src="../resources/upload/${dto.img}" width="50%" height="50%" class="img_1" id="img" onclick="clickImg()"	/>
		</c:if>
		<c:if test="${dto.img == null}">
			<img src="../resources/images/star.gif" width="50%" height="50%" class="img_1" id="img" onclick="clickImg()"	/>
		</c:if>
		</TD>
	</TR>
	<TR>
		<TD class="td_1"><DIV class="div_2">글내용</DIV></TD>
		<TD class="td_1" colspan="5" style="text-align: left; vertical-align: top; height: 300">
			<DIV class="div_2">${dto.content}</DIV>
		</TD>
	</TR>
	<TR>
		<TD colspan="6" align="right">
		<c:if test="${sessionScope.sid != null}">
			<c:if test="${sessionScope.sid == dto.writer}">
				<BUTTON class="btn_1" type="button" onclick="location.href='updateForm.bo?num=${dto.num}'">글수정</BUTTON>
				&nbsp;
				<BUTTON class="btn_1" type="button" onclick="location.href='deleteForm.bo?num=${dto.num}'">글삭제</BUTTON>
				&nbsp;
			</c:if>
				<BUTTON class="btn_1" type="button" onclick="location.href='writeForm.bo?num=${dto.num}&ref=${dto.ref}&re_step=${dto.re_step}&re_level=${dto.re_level}'">답글쓰기</BUTTON>
				&nbsp;
		</c:if>
			<BUTTON class="btn_1" type="button" onclick="location.href='list.bo'">글목록</BUTTON>
		</TD>
	</TR>
</TABLE>
<br />

<TABLE style="width: 600;">
	<TR>
		<TD width="30%"></TD>
		<TD align="left">
		<c:if test="${title_pre != null}">
			<SPAN class="span_2">
				<LABEL class="lab_1" onclick="document.getElementById('pre').click();">[이전글]</LABEL>
			</SPAN>
			<A href="content.bo?num=${dto.num - 1}" id="pre">${title_pre}</A>
		</c:if>
		<c:if test="${title_pre == null}">
			<DIV class="div_2">글의 처음입니다.</DIV>
		</c:if>
		</TD>
	</TR>	
	<TR>
		<TD width="30%"></TD>
		<TD align="left">
		<c:if test="${title_next != null}">
			<SPAN class="span_2">
				<LABEL class="lab_1" onclick="document.getElementById('next').click();">[다음글]</LABEL>
			</SPAN>
			<A href="content.bo?num=${dto.num + 1}" id="next">${title_next}</A>
		</c:if>
		<c:if test="${title_next == null}">
			<DIV class="div_2">글의 마지막입니다.</DIV>
		</c:if>
		</TD>
	</TR>	
</TABLE>

<script src="../js/clickImg.js"></script>
</CENTER>