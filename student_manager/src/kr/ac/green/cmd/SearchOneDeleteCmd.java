package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class SearchOneDeleteCmd implements ICmd{

	@Override
	public void action(HttpServletRequest request) {
		request.setAttribute("nextPage", "search_one_delete.jsp");
	}
	
}
