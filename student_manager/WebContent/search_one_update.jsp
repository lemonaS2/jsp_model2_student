<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>����</title>
<link href="css/bootstrap.css" rel="stylesheet" />
<style>
	.mycontainer {
		margin: 0px auto;
		padding: 30px;
		width: 1000px;
		border: 1px solid #cccccc;
		background-color: WHITE;
	}
</style>
</head>

<body>
	<jsp:include page="menu.jsp" />
	<div align="center" style="margin-bottom: 40px; margin-top:40px;">
		<h2>�л� ���� ����</h2>
	</div>	 
	<div class="mycontainer">
		
		<form action="MainServlet" method="post">
			<div class="form-inline" align="center"
				style="margin-top: 10px; margin-bottom: 10px;">
				<select class="form-control">
					<option selected>ID</option>
				</select> 
				<input type="text" class="form-control" name="id" placeholder="�˻�� �Է��ϼ���." />
				<input type="submit" class="btn btn-success" value="�˻�"/>
				<input type="hidden" name="cmd" value="updateInfo" />
			</div>
		</form> 


	</div>
</body>
<jsp:include page="footer.jsp" />
</html>