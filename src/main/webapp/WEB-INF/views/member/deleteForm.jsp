<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/table.css"	/>

<CENTER>
	<B><FONT size="6" color="lightgray">회원 탈퇴</FONT></B>
	<br />
<FORM action="deletePro.me" method="post">

	<TABLE style="width: 330;">
		<TR>
			<TD align="right">
				<BUTTON type="button" class="btn_1" onclick="location.href='main.me'">메인</BUTTON>
			</TD>
		</TR>
	</TABLE>

	<TABLE style="height: 15%;" class="tab_1">
		<TR>
			<TD align="right" width="30%"><div class="div_1">비밀번호 : </div></TD>
			<TD>
				<input type="password" name="pw" size="15" maxlength="16"	/>
			</TD>
		</TR>
	</TABLE>
	<br />
	<DIV style="text-align:center;">
		<BUTTON type="submit" class="btn_1">회원탈퇴</BUTTON>
	</DIV>
</FORM>
</CENTER>