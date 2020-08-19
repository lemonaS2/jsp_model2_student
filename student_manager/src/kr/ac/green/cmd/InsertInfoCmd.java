package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.StudentDao;
import kr.ac.green.dto.Student;

public class InsertInfoCmd implements ICmd{

	@Override
	public void action(HttpServletRequest request) {
		StudentDao dao = StudentDao.getDao();
		Connection con = dao.connect();
		Student student = new Student();
		student.setS_name(request.getParameter("s_name"));
		student.setS_tel(request.getParameter("s_tel"));
		student.setS_grade(Integer.parseInt(request.getParameter("s_grade")));
		student.setS_class(Integer.parseInt(request.getParameter("s_class")));
		int result = dao.insertInfo(con, student);
		dao.disconnect(con);
		request.setAttribute("isRedirect", true);
		request.setAttribute("nextPage", request.getContextPath());
	}
	
}
 