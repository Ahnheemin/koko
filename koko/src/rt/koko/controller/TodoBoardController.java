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
import rt.koko.action.TodoBoardDeleteAction;
import rt.koko.action.TodoBoardInsertAction;
import rt.koko.action.TodoBoardReadAction;
import rt.koko.action.TodoBoardUpdateAction;
import rt.koko.action.TodoBoardUpdateFormAction;
import rt.koko.action.TodoReplyDeleteAction;
import rt.koko.action.TodoReplyInsertAction;
import rt.koko.action.TodoReplyReadAction;


@WebServlet("/todoBoard/*")
public class TodoBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TodoBoardController() {
        super();
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// utf-8 인코딩
    	request.setCharacterEncoding("utf-8");
    	
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+11);
		System.out.println(command);
		
		Action action = null;
		ActionForward forward = null;
		
		// Action 실행 영역
		
		if(command.equals("todoBoardInsertAction.do")) {
			action = new TodoBoardInsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("todoBoardReadAction.do")) {
			action = new TodoBoardReadAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("todoBoardUpdateFormAction.do")) {
			action = new TodoBoardUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("todoBoardUpdateAction.do")) {
			action = new TodoBoardUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("todoBoardDeleteAction.do")) {
			action = new TodoBoardDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("todoReplyReadAction.do")) {
			action = new TodoReplyReadAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("todoReplyInsertAction.do")) {
			action = new TodoReplyInsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("todoReplyDeleteAction.do")) {
			action = new TodoReplyDeleteAction();
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
