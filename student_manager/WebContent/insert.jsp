<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>�л����</title>
<link href="css/bootstrap.css" rel="stylesheet" />
</head>


<body>
	<jsp:include page="menu.jsp" />
	<form action="MainServlet" method="post">
	<div class="container" align="center"> 
		<div align="left"
			style="width: 500px; border: 1px solid #eeeeee; padding: 20px; background-color: WHITE;">
				<h3>�л� ���</h3>
			<hr />  
 
<!-- 			<div class="form-inline" style="margin-bottom: 5px"> -->
<!-- 				<label style="width: 120px">���̵�</label> <input type="text" -->
<!-- 					style="width: 320px" class="form-control" placeholder="���̵� �Է�" /> -->
<!-- 			</div> -->
		
			<div class="form-inline" style="margin-bottom: 5px">
				<label style="width: 120px">�̸�</label> 
				<input type="text" name="s_name" style="width: 320px" class="form-control" placeholder="�̸��� �Է��ϼ���" required/>
			</div>

			<div class="form-inline" style="margin-bottom: 5px">
				<label style="width: 120px">��ȭ��ȣ</label> 
				<input type="text" name="s_tel" style="width: 320px" class="form-control" placeholder="��ȭ��ȣ�� �Է��ϼ���" required/>
			</div>
			

			<div class="form-inline" style="margin-bottom: 5px">
				<label style="width: 120px">�г�</label> 
				<input type="text" name="s_grade" style="width: 320px" class="form-control" placeholder="�г��� �Է��ϼ���" required/>
			</div>
				
			<div class="form-inline" style="margin-bottom: 5px">
				<label style="width: 120px">�й�</label> 
				<input type="text" name="s_class" style="width: 320px" class="form-control" placeholder="�й��� �Է��ϼ���" required/>
			</div>
			
			<hr />		
 
			<div class="form-inline" style="margin-bottom: 10px" align="center">
				<input type="submit" class="btn btn-success" value="����ϱ�" /> 
			<a href="MainServlet">	
				<input type="button" class="btn btn-primary" value="�ڷΰ���" />
			</a>	
			</div>
			<input type="hidden" name="cmd" value="insertInfo" />
		</div>
	</div>
	</form>
		<jsp:include page="footer.jsp" />
</body>
</html>