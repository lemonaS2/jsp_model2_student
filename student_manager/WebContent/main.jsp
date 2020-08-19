<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<link href="css/bootstrap.css" rel="stylesheet" />
</head>

<body>
	<jsp:include page="menu.jsp" />

	<div class="container" style="background-color: white;">
		<div class="row">
<!-- 			<div class="col-md-12"> -->
<!-- 				<img src="imgs/green.jpg" width="1150px" height="350px" -->
<!-- 					style="padding: 30px;" /> -->
<!-- 			</div> -->
			<h1 align="center" style="margin-bottom: 40px">학생 정보 관리 시스템</h1>
		</div>
		<!-- 		<div class="row" style="margin-top: 10px; padding: 50px"> -->
		<!-- 			<div class="col-md-5"> -->
		<!-- 				<img src="imgs/girl2.jpg" style="width: 450px; height: 300px;" /> -->
		<!-- 			</div> -->
		<!-- 			<div class="col-md-5"> -->
		<!-- 				<img src="imgs/girl3.jpg" style="width: 600px; height: 300px;" /> -->
		<!-- 			</div> -->
		<!-- 		</div> -->
   
	</div>
	<jsp:include page="board.jsp" />

	<hr /> 

<!-- 	<div class="row" style="background-color: #ffffff;"> -->
<!-- 		<div class="col-xs-12" align="center"> -->
<!-- 			<div class="form-inline" style="margin-top: 40px"> -->
<!-- 				<select class="form-control"> -->
<!-- 					<option>ID</option> -->
<!-- 					<option>Name</option> -->
<!-- 					<option>Class</option> -->
<!-- 				</select>  <input type="text" style="width: 300px" class="form-control" placeholder="검색어를 입력하세요" /> -->
<!-- 				<input type="button" class="btn btn-success" value="검색" /> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->



	
	<jsp:include page="footer.jsp" />
</body>
</html>