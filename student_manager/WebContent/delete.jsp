<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.green.dto.Student" %>
<%
	Student list = (Student)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생 정보 삭제</title>
<link href="css/bootstrap.css" rel="stylesheet" />
</head>


<body>
	<jsp:include page="menu.jsp" />
	<form action="MainServlet" method="post">
	<div class="container" align="center"> 
		<div align="left"
			style="width: 700px; border: 1px solid #eeeeee; padding: 20px; background-color: WHITE;">
			<h3>학생 정보 삭제</h3>
			<hr />
				
			<div class="form-inline" style="margin-bottom: 5px">
				<label style="width: 120px">아이디</label> 
				<input type="text" name="s_id" value="<%=list.getS_id() %>" style="width: 320px" class="form-control" placeholder="아이디 입력" readonly />
			</div>

			<div class="form-inline" style="margin-bottom: 5px">
				<label style="width: 120px">이름</label> 
				<input type="text" name="s_name" value="<%=list.getS_name() %>" style="width: 320px" class="form-control" placeholder="이름 입력" readonly />
			</div>

			<div class="form-inline" style="margin-bottom: 5px">
					<label style="width: 120px">전화번호</label> 
					<input type="text" name="s_tel" value="<%=list.getS_tel() %>" style="width: 320px" class="form-control" placeholder="전화번호를 입력하세요" />
			</div> 
			

			<div class="form-inline" style="margin-bottom: 5px">
				<label style="width: 120px">학년</label> 
				<input type="text" name="s_grade" value="<%=list.getS_grade() %>" style="width: 320px" class="form-control" placeholder="학년을 입력하세요" />
			</div>
				
			<div class="form-inline" style="margin-bottom: 5px">
				<label style="width: 120px">학반</label> 
				<input type="text" name="s_class" value="<%=list.getS_class() %>" style="width: 320px" class="form-control" placeholder="반을 입력하세요" />
			</div>
			<hr />

			<div class="form-inline" style="margin-bottom: 10px" align="center">
				<input type="submit" class="btn btn-danger" value="정보삭제" />
				<input type="hidden" name="cmd" value="sendDelete" /> 
				<input type="button" class="btn btn-primary" onclick="goBack()" value="뒤로가기" />
			</div>
				</div>
			</div>
		</form>	
	<jsp:include page="footer.jsp" />
</body>
<script> 
	function goBack(){  
		location.href="MainServlet?cmd=searchOne_Delete";
	}
</script>
</html>