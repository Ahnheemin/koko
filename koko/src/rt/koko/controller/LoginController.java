package rt.koko.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.action.Action;
import rt.koko.action.ActionForward;
import rt.koko.action.LoginAction;
import rt.koko.action.LoginFormAction;
import rt.koko.action.ProjectAction;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login/*")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// utf-8 인코딩
    	request.setCharacterEncoding("utf-8");
    	
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+7);
		System.out.println(command);
		
		Action action = null;
		ActionForward forward = null;
		
		// Action 실행 영역
		
		if(command.equals("loginAction.do")) {
			action = new LoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("loginFormAction.do")) {
			action = new LoginFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("projectAction.do")) {
			action = new ProjectAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


}
