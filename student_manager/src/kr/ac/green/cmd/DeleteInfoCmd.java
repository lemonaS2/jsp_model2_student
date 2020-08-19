package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.StudentDao;
import kr.ac.green.dto.Student;

public class DeleteInfoCmd implements ICmd {

	@Override
	public void action(HttpServletRequest request) {
		StudentDao dao = StudentDao.getDao();
		Connection con = dao.connect();
		int id = Integer.parseInt(request.getParameter("id"));
		Student list = dao.selectOne(con, id);
		dao.disconnect(con);
		 
		boolean flag = true;
		
		if(list.getS_id() == 0){   
			request.setAttribute("nextPage", "nodata.jsp"); 
			flag = false; 
		} 
		  
		if(flag){
			request.setAttribute("list", list);
			request.setAttribute("nextPage", "delete.jsp");
		} 
	}
	
}
