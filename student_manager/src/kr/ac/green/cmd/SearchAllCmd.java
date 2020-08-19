package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.StudentDao;
import kr.ac.green.dto.Student;

public class SearchAllCmd implements ICmd{

	@Override
	public void action(HttpServletRequest request) {
		StudentDao dao = StudentDao.getDao();
		Connection con = dao.connect();
		
		String[] options = request.getParameterValues("option");
		String search_desc = request.getParameter("search_desc");
		
		String option = null;
		for(String op : options){
			  option = op; 
        }
		 
		Student[] list = dao.searchAll(con, option, search_desc);
		
		dao.disconnect(con);
		request.setAttribute("list", list);
		request.setAttribute("nextPage", "main.jsp");
	}
}
