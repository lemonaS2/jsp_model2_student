package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.StudentDao;
import kr.ac.green.dto.Student;

public class MainCmd implements ICmd{

	@Override
	public void action(HttpServletRequest request) {
		StudentDao dao = StudentDao.getDao();
		Connection con = dao.connect();
		Student[] list = dao.selectAll(con);
		dao.disconnect(con);
		request.setAttribute("list", list);
		request.setAttribute("nextPage", "main.jsp");
	}

}
