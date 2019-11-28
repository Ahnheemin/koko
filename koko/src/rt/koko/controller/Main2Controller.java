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
import rt.koko.action.ProjectAction;

/**
 * Servlet implementation class Main2Controller
 */
@WebServlet("/main2/*")
public class Main2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Main2Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 // utf-8 인코딩
	request.setCharacterEncoding("utf-8");
	
	String requestURI = request.getRequestURI();
	System.out.println(requestURI);
	String contextPath = request.getContextPath();
	System.out.println(contextPath);
	String command = requestURI.substring(contextPath.length()+7);
	System.out.println(command);
	
	Action action = null;
	ActionForward forward = null;
	
	// Action 실행 영역
	
	if(command.equals("projectAction.do")) {
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
