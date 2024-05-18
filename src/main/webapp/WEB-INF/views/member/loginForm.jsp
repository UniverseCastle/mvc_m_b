<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/table.css"	/>

<CENTER>
	<B><FONT size="6" color="gray">로그인</FONT></B>
</CENTER>
<br />

<FORM action="loginPro.me" method="post">
	<TABLE style="height: 15%;" align="center" cellspacing="0" cellpadding="0" class="tab_1">
		<TR>
			<TD align="right" width="30%"><DIV class="div_1">아이디 : </DIV></TD>
			<TD>
				<input type="text" name="id" size="15" maxlength="10"		/>
			</TD>
		</TR>
		<TR>
			<TD align="right" width="30%"><DIV class="div_1">비밀번호 : </DIV></TD>
			<TD>
				<input type="password" name="pw" size="15" maxlength="16"	/>
			</TD>
		</TR>
	</TABLE>
	<br />
	<DIV style="text-align:center;">
		<BUTTON type="submit" class="btn_1">로그인</BUTTON>
		<BUTTON type="button" class="btn_1" onclick="location.href='main.me'">메인</BUTTON>
	</DIV>
</FORM>