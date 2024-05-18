<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/table.css"	/>

<CENTER>
	<B><FONT size="6" color="darkgray">글 삭제</FONT></B>
	<br /><br />
<FORM action="deletePro.bo" method="post">
	<TABLE class="tab_1" style="height: 10%;">
		<TR>
			<TD><DIV class="div_2" align="right">비밀번호 : </DIV></TD>
			<TD>
				<input type="password" name="passwd" maxlength="12" size="10"	/>
				<input type="hidden" name="num" value="${num}">
			</TD>
		</TR>
	</TABLE>
	<br />
	<BUTTON class="btn_1" type="submit">삭제하기</BUTTON>
	<BUTTON class="btn_1" type="button" onclick="location.href='list.bo'">글목록</BUTTON>
</FORM>
</CENTER>