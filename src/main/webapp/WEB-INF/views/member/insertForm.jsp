<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/table.css" 	/>

<CENTER>
	<FONT size="6" color="gray"><B>회원가입</B></FONT>
	<br />

	<TABLE style="width: 330;">
		<TR>
			<TD align="right">
				<BUTTON type="button" class="btn_1" onclick="location.href='main.me'">메인</BUTTON>
			</TD>
		</TR>
	</TABLE>

<FORM action="insertPro.me" method="post">
	<TABLE class="tab_1">
		<TR>
			<TD width="35%"><div class="div_2">아이디</div></TD>
			<TD align="left">
				<input type="text" name="id" id="id" size="10" maxlength="10"			/>	&nbsp;
				<input type="button" value="중복확인" onclick="idCheck()" class="btn_1"	/>
			</TD>
		</TR>
		<TR>
			<TD></TD>
			<TD align="left">
				<DIV id="idResult"></DIV>
			</TD>
		</TR>
		<TR>
			<TD><div class="div_2">비밀번호</div></TD>
			<TD align="left">
				<input type="password" name="pw" size="10" maxlength="16"	/>	<br />
			</TD>
		</TR>
		<TR>
			<TD><div class="div_2">이름</div></TD>
			<TD align="left">
				<input type="text" name="name" size="5" maxlength="12"		/>	<br />
			</TD>
		</TR>
		<TR>
			<TD><div class="div_2">생년월일</div></TD>
			<TD align="left">
				<input type="date" name="birth"		/>	<br />
			</TD>
		</TR>
		<TR>
			<TD><div class="div_2">통신사</div></TD>
			<TD align="left">
				<SELECT name="phone1">
					<OPTION value="KT">KT</OPTION>
					<OPTION value="SKT">SKT</OPTION>
					<OPTION value="U+">U+</OPTION>
					<OPTION value="알뜰폰">알뜰폰</OPTION>
				</SELECT>
			</TD>
		</TR>
		<TR>
			<TD><div class="div_2">폰번호</div></TD>
			<TD align="left">
				<input type="text" name="phone2" size="15" maxlength="15"	/>	<br />
			</TD>
		</TR>
		<TR>
			<TD><div class="div_2">성별</div></TD>
			<TD align="left">
				<SPAN class="div_1"><LABEL for="m">남자</LABEL></SPAN><input type="radio" name="gender" value="남자" id="m">	&nbsp;
				<SPAN class="div_1"><LABEL for="w">여자</LABEL></SPAN><input type="radio" name="gender" value="여자" id="w">	<br />
			</TD>
		</TR>
		<TR>
			<TD colspan="2">
				<input type="reset" value="다시작성" class="btn_1"	/>	&nbsp;
				<input type="submit" value="회원가입" class="btn_1"	/>	&nbsp;
			</TD>
		</TR>
	</TABLE>
	<script src="../js/idCheck.js"></script>
</FORM>
</CENTER>