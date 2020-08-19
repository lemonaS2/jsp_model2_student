package kr.ac.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	@Override
	public void init() throws ServletException { 
		super.init();
		CmdManager.init();
	} 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doit(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc_kr");
		response.setContentType("text/html; charset=EUC-KR");
		doit(request, response);
	}

	protected void doit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		if(cmd == null){
			cmd = "main";
		}
		 
		CmdManager.doAction(request, cmd);
		
		String nextPage = request.getAttribute("nextPage").toString();
		 
		if(request.getAttribute("isRedirect") != null){
			response.sendRedirect(nextPage);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}
	}
}
