<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>    
<%@ page import="kr.ac.green.dto.Student" %>
 
<%
	Student[] list2 = (Student[])request.getAttribute("list");

	int pageNum = 1;
	String paramPageNum = request.getParameter("pageNum");
	if(paramPageNum != null){
		pageNum = Integer.parseInt(paramPageNum);
	}
	
	int size = list2.length;
	int perPage = 10;
	int pageCount = size / perPage;
	if((size % perPage) != 0){
		pageCount++;
	}
	
	int start = (pageNum - 1) * perPage;
	int end = start + perPage;
	if(end > size){
		end = size;
	}
	
	ArrayList<Student> arrayList = new ArrayList<Student>();
	
	for(Student temp : list2){
	
	  arrayList.add(temp);
	
	}
	
	List<Student> list = arrayList.subList(start, end);


%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
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

	<div class="mycontainer">
		<h3>학생 정보</h3>
		
		<form action="MainServlet" method="post">
			<div class="form-inline" align="right"
				style="margin-top: 10px; margin-bottom: 10px;">
				<select name="option" class="form-control">
					<option value="s_id">ID</option>
					<option value="s_name">Name</option>
					<option value="s_class">Class</option>
				</select>   
				<input type="text" class="form-control" name="search_desc" placeholder="검색어를 입력하세요." />
				<input type="submit" class="btn btn-success" value="검색"/>
				<input type="hidden" name="cmd" value="searchAll" />
			</div>
		</form> 

		<table class="table">
			<tr class="active">
				<th>ID</th>
				<th>NAME</th>
				<th>Tel</th>
				<th>Grade</th>
				<th>Class</th>
			</tr>
			<% 
				if(list.size()  == 0){
			%>
			<tr>
				<td colspan="5" s>
					<div align="center">
						<h3>저장 된 정보가 없습니다.</h3>
					</div>
				</td>
			</tr>
			<%
				}else{
					for (Student temp : list) {
			%>
			<tr>
				<td><%= temp.getS_id() %></td>
				<td><%= temp.getS_name() %></td> 
				<td><%= temp.getS_tel() %></td>
				<td><%= temp.getS_grade() %></td> 
				<td><%= temp.getS_class() %></td>
			</tr>
			<% 
					}
				}
			%>
			
		</table>

		<div align="center">
			<ul class="pagination">
				<li><a href="#" aria-labe="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				<%
					for(int i = 1; i <= pageCount; i++){
						if(i == pageNum){
				%>
				<li><a href="#"><b><%= i %></b></a></li>
				<%
					} else {  
				%>	
				<li><a href="MainServlet?pageNum=<%= i %>"><%= i %></a></li>
				<%
						}
					} 
				%>
<!-- 				<li><a href="#">3</a></li> -->

				<li><a href="#" aria-labe="Previous"> <span
						aria-hidden="true">&raquo;</span>
				</a></li>

			</ul>
		</div>

	</div>
</body>

</html>