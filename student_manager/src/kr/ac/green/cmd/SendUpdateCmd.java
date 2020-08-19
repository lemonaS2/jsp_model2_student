package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.StudentDao;
import kr.ac.green.dto.Student;

public class SendUpdateCmd implements ICmd{

	@Override
	public void action(HttpServletRequest request) {
		StudentDao dao = StudentDao.getDao();
		Connection con = dao.connect();
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		String s_tel = request.getParameter("s_tel");
		int s_grade = Integer.parseInt(request.getParameter("s_grade"));
		int s_class = Integer.parseInt(request.getParameter("s_class"));

		Student student = new Student(s_id, s_tel, s_grade, s_class);
		
		dao.UpdateInfo(con, student);
		dao.disconnect(con);
		
		request.setAttribute("isRedirect", true);
		request.setAttribute("nextPage", request.getContextPath());
	}

}
