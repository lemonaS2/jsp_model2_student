<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생등록</title>
<link href="css/bootstrap.css" rel="stylesheet" />
</head>


<body>
	<jsp:include page="menu.jsp" />
	<form action="MainServlet" method="post">
	<div class="container" align="center"> 
		<div align="left"
			style="width: 500px; border: 1px solid #eeeeee; padding: 20px; background-color: WHITE;">
				<h3>학생 등록</h3>
			<hr />  
 
<!-- 			<div class="form-inline" style="margin-bottom: 5px"> -->
<!-- 				<label style="width: 120px">아이디</label> <input type="text" -->
<!-- 					style="width: 320px" class="form-control" placeholder="아이디 입력" /> -->
<!-- 			</div> -->
		
			<div class="form-inline" style="margin-bottom: 5px">
				<label style="width: 120px">이름</label> 
				<input type="text" name="s_name" style="width: 320px" class="form-control" placeholder="이름을 입력하세요" required/>
			</div>

			<div class="form-inline" style="margin-bottom: 5px">
				<label style="width: 120px">전화번호</label> 
				<input type="text" name="s_tel" style="width: 320px" class="form-control" placeholder="전화번호를 입력하세요" required/>
			</div>
			

			<div class="form-inline" style="margin-bottom: 5px">
				<label style="width: 120px">학년</label> 
				<input type="text" name="s_grade" style="width: 320px" class="form-control" placeholder="학년을 입력하세요" required/>
			</div>
				
			<div class="form-inline" style="margin-bottom: 5px">
				<label style="width: 120px">학반</label> 
				<input type="text" name="s_class" style="width: 320px" class="form-control" placeholder="학반을 입력하세요" required/>
			</div>
			
			<hr />		
 
			<div class="form-inline" style="margin-bottom: 10px" align="center">
				<input type="submit" class="btn btn-success" value="등록하기" /> 
			<a href="MainServlet">	
				<input type="button" class="btn btn-primary" value="뒤로가기" />
			</a>	
			</div>
			<input type="hidden" name="cmd" value="insertInfo" />
		</div>
	</div>
	</form>
		<jsp:include page="footer.jsp" />
</body>
</html>