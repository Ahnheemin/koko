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
import rt.koko.action.AddressDeleteAction;
import rt.koko.action.AddressInsertAction;
import rt.koko.action.AddressInsertFormAction;
import rt.koko.action.AddressListAction;
import rt.koko.action.AddressSelectAction;
import rt.koko.action.AddressUpdateAction;



@WebServlet("/address/*")
public class AddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddressController() {
		super();
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //=> �븳湲�蹂��솚
		String path = request.getPathInfo().substring(1);
    	System.out.println(path +"경로입니당.");
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(path.equals("insert_form.do")) {
    		action = new AddressInsertFormAction();
    		System.out.println("insert_form.do 입니당");
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(path.equals("AddressInsertAction.do")) {
    		action = new AddressInsertAction();
    		
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(path.equals("list.do")) {
    		action = new AddressListAction();
    		
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(path.equals("delete.do")) {
    		action = new AddressDeleteAction();
    		System.out.println("delete.do 紐낅졊諛쏆븯�떎!");
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(path.equals("select.do")) {
    		action = new AddressSelectAction();
    		System.out.println("select.do 紐낅졊諛쏆븯�떎!");
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(path.equals("updateAction.do")) {
    		action = new AddressUpdateAction();
    		System.out.println("updateAction.do 紐낅졊諛쏆븯�떎!");
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
    			RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
    			rd.forward(request, response);
    		}
    		
    	}
    	
    	
    	
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //=> �븳湲�蹂��솚
		doProcess(request, response);
		request.setCharacterEncoding("utf-8"); //=> �븳湲�蹂��솚
		
	}

}
