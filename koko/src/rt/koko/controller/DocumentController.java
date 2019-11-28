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
import rt.koko.action.DocumentDeleteAction;
import rt.koko.action.DocumentDetailAction;
import rt.koko.action.DocumentInsertAction;
import rt.koko.action.DocumentInsertFormAction;
import rt.koko.action.DocumentListAction;
import rt.koko.action.DocumentUpdateAction;
import rt.koko.action.DocumentUpdateFormAction;

@WebServlet("/document/*")
public class DocumentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
    public DocumentController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length()+10);
    	System.out.println(command);
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(command.equals("DocumentInsertFormAction.do")) {
    		action = new DocumentInsertFormAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("DocumentInsertAction.do")) {
    		action = new DocumentInsertAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	} else if(command.equals("DocumentListAction.do")) {
    		action = new DocumentListAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	} else if(command.equals("DocumentDetailAction.do")) {
    		action = new DocumentDetailAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	} else if(command.equals("DocumentUpdateFormAction.do")) {
    		action = new DocumentUpdateFormAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	} else if(command.equals("DocumentUpdateAction.do")) {
    		action = new DocumentUpdateAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	} else if(command.equals("DocumentDeleteAction.do")) {
    		action = new DocumentDeleteAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	
    	// forward Ω√¿€
    	if(forward != null) {
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		}else {
    			RequestDispatcher dispacher = request.getRequestDispatcher(forward.getPath());
    			dispacher.forward(request, response);
    		}
    	} // forward ≥°
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
