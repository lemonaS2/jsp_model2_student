<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<nav class="navbar navbar-default">
	<div class="container">
		<ul class="nav navbar-nav">
<!-- 			<li><a href="index.do">홈</a></li> -->
<!-- 			<li><a href="main.do">메인</a></li> -->
<!-- 			<li><a href="login.do">로그인</a></li> -->
			<li><a href="MainServlet?cmd=main">메인</a></li>
			<li><a href="MainServlet?cmd=insert">학생정보 등록</a></li>
			<li><a href="MainServlet?cmd=searchOne_Update">학생정보 수정</a></li>
			<li><a href="MainServlet?cmd=searchOne_Delete">학생정보 삭제</a></li>
			
			
			
<!-- 			<li><a href="board.do">게시판</a></li> -->
		</ul>
	</div>
</nav>