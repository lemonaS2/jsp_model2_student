package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.StudentDao;

public class SendDeleteCmd implements ICmd{

	@Override
	public void action(HttpServletRequest request) {
		StudentDao dao = StudentDao.getDao();
		Connection con = dao.connect();
		int s_id = Integer.parseInt(request.getParameter("s_id"));
		dao.DeleteInfo(con, s_id);
		dao.disconnect(con);
		
		request.setAttribute("isRedirect", true);
		request.setAttribute("nextPage", request.getContextPath());
	}

}
