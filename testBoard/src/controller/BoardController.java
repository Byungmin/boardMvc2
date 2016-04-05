package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController extends HttpServlet {

	protected void doPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		System.out.println("RequestURI"+RequestURI);
		System.out.println("contextPath"+contextPath);
		
		String command = RequestURI.substring(contextPath.length());
		System.out.println("command"+command);
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/main.bo")){
			System.out.println("check");
		}
		

		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPro(req, resp);
	}
}
