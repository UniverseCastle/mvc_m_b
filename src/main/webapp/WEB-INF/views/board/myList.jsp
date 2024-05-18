<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="../css/table.css"	/>

<CENTER>
	<B><FONT size="6" color="darkgray">[${sessionScope.sid}]님의 글목록(전체글:${myCount})</FONT></B>
	<br />
<TABLE style="width: 600;">
	<TR>
		<TD align="right">
				<SPAN class="span_1"><A href="writeForm.bo">글쓰기</A></SPAN>
				<SPAN class="span_1"><A href="list.bo">메인으로</A></SPAN>
				<SPAN class="span_1"><A href="../member/logout.me">로그아웃</A></SPAN>
		</TD>
	</TR>
</TABLE>
<c:if test="${myCount == 0}">
<TABLE>
	<TR>
		<TD height="500">
			<B><FONT size="6" color="darkgray">등록된 글이 없습니다.</FONT></B>
		</TD>
	</TR>
</TABLE>
</c:if>

<c:if test="${myCount > 0}">
<TABLE class="tab_4" style="height: 15%">
	<TR>
		<TH class="th_1" style="width: 10%;"><DIV class="div_2">글번호</DIV></TH>
		<TH class="th_1" style="width: 50%;"><DIV class="div_2">글제목</DIV></TH>
		<TH class="th_1" style="width: 15%;"><DIV class="div_2">작성자</DIV></TH>
		<TH class="th_1" style="width: 15%;"><DIV class="div_2">작성일</DIV></TH>
		<TH class="th_1" style="width: 10%;"><DIV class="div_2">조회수</DIV></TH>
	</TR>
	<c:forEach var="dto" items="${myList}">
		<TR>
			<TD class="td_1"><DIV class="div_2">${dto.num}</DIV></TD>
			<TD class="td_1" align="left">
				<SPAN class="span_2">
					<A href="content.bo?num=${dto.num}">${dto.title}</A>
					<c:if test="${dto.img != null}">
						<img src="../resources/images/file.png" width="15" height="15"	/>
					</c:if>
					<c:if test="${dto.readCount >= 30}">
						<img src="../resources/images/hot.gif" height="15"	/>
					</c:if>
				</SPAN>
			</TD>
			<TD class="td_1"><DIV class="div_2">${dto.writer}</DIV></TD>
			<TD class="td_1"><DIV class="div_2">${dto.reg}</DIV></TD>
			<TD class="td_1"><DIV class="div_2">${dto.readCount}</DIV></TD>
		</TR>
	</c:forEach>
</TABLE>
</c:if>

<c:if test="${myCount > 0}">
	<c:set var="pageCount" value="${myCount / pageSize + (myCount % pageSize == 0 ? 0 : 1)}"	/>
	<c:set var="pageBlock" value="10"	/>
	<fmt:parseNumber var="result" value="${(currentPage - 1) / 10}"	/>
	<c:set var="startPage" value="${result * 10 + 1}"	/>
	<c:set var="endPage" value="${startPage * pageBlock - 1}"	/>
	
	<c:if test="${endPage > pageCount}">
		<c:set var="endPage" value="${pageCount}"	/>
	</c:if>
	<c:if test="${startPage > 10}">
		<A href="myList.bo?pageNum=${startPage - 10}">[이전]</A>
	</c:if>
	<c:if test="${endPage < pageCount}">
		<A href="myList.bo?pageNum=${startPage + 10}">[다음]</A>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
		<A href="myList.bo?pageNum=${i}">[${i}]</A>
	</c:forEach>
</c:if>
</CENTER>