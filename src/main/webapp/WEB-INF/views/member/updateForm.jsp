<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/table.css" 	/>

<CENTER>
	<B><FONT size="6" color="darkgray">정보 수정</FONT></B>
<br />

<FORM action="updatePro.me" method="post">

	<TABLE style="width: 330;">
		<TR>
			<TD align="right">
				<BUTTON type="button" class="btn_1" onclick="location.href='main.me'">메인</BUTTON>
			</TD>
		</TR>
	</TABLE>
	
	<TABLE class="tab_1">
		<TR>
			<TD width="35%"><div class="div_1">아이디</div></TD>
			<TD align="left">
				<SPAN class="span_1">${sessionScope.sid}</SPAN>	<br />
				<input type="hidden" name="id" value="${sessionScope.sid}">
			</TD>
		</TR>
		<TR>
			<TD><div class="div_1">비밀번호</div></TD>
			<TD align="left">
				<input type="password" name="pw" size="15"	/>	<br />
			</TD>
		</TR>
		<TR>
			<TD><div class="div_1">이름</div></TD>
			<TD align="left">
				<input type="text" name="name" size="5" value="${dto.name}"	/>	<br />
			</TD>
		</TR>
		<TR>
			<TD><div class="div_1">생년월일</div></TD>
			<TD align="left">
				<input type="date" name="birth" value="${dto.birth}"	/>	<br />
			</TD>
		</TR>
		<TR>
			<TD><div class="div_1">통신사</div></TD>
			<TD align="left">
				<SELECT name="phone1">
					<OPTION value="${dto.phone1}" selected>${dto.phone1}</OPTION>
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
				<input type="text" name="phone2" size="15" value="${dto.phone2}"	/>	<br />
			</TD>
		</TR>
		<TR>
			<TD><div class="div_1">성별</div></TD>
			<TD align="left">
				<SPAN class="span_1">${dto.gender}</SPAN>
			</TD>
		</TR>
		<TR>
			<TD colspan="2">
				<input type="reset" value="다시작성" class="btn_1"	/>	&nbsp;
				<input type="submit" value="수정완료" class="btn_1"	/>
			</TD>
		</TR>
	</TABLE>
</FORM>
</CENTER>