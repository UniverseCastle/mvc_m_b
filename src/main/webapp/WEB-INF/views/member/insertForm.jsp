<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/table.css" 	/>
<style>
	span {
		font-size: 12px;
		font-weight: 700;
		color: #2f4f4f;
	}
</style>

<CENTER>
	<FONT size="6" color="gray"><B>회원가입</B></FONT>
</CENTER>

<br />

<script>
	function idCheck(){
		var id = document.getElementById("id").value;
		open("confirmId.me?id="+id, 'confirm', 'width=400, height=400');
	}
</script>
    
<FORM action="insertPro.me" method="post">
	<TABLE align="center" cellspacing="0" cellpadding="0" class="tab_1">
		<TR>
			<TD width="35%"><div class="div_1">아이디</div></TD>
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
			<TD><div class="div_1">비밀번호</div></TD>
			<TD align="left">
				<input type="password" name="pw" size="10" maxlength="16"	/>	<br />
			</TD>
		</TR>
		<TR>
			<TD><div class="div_1">이름</div></TD>
			<TD align="left">
				<input type="text" name="name" size="5" maxlength="12"		/>	<br />
			</TD>
		</TR>
		<TR>
			<TD><div class="div_1">생년월일</div></TD>
			<TD align="left">
				<input type="date" name="birth"		/>	<br />
			</TD>
		</TR>
		<TR>
			<TD><div class="div_1">통신사</div></TD>
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
			<TD><div class="div_1">폰번호</div></TD>
			<TD align="left">
				<input type="text" name="phone2" size="15" maxlength="15"	/>	<br />
			</TD>
		</TR>
		<TR>
			<TD><div class="div_1">성별</div></TD>
			<TD align="left">
				<SPAN class="div_1"><LABEL for="m">남자</LABEL></SPAN><input type="radio" name="gender" value="남자" id="m">	&nbsp;
				<SPAN class="div_1"><LABEL for="w">여자</LABEL></SPAN><input type="radio" name="gender" value="여자" id="w">	<br />
			</TD>
		</TR>
		<TR>
			<TD colspan="2">
				<input type="reset" value="다시작성" class="btn_1"	/>	&nbsp;
				<input type="submit" value="회원가입" class="btn_1"	/>	&nbsp;
				<input type="button" value="메인으로" class="btn_1" onclick="location.href='main.me'"	/>
			</TD>
		</TR>
	</TABLE>
</FORM>