package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.service.TodoBoardService;

public class TodoBoardUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		TodoBoardService service = TodoBoardService.getInstance();
		
		service.todoBoardUpdateService(request);
		
		String m_id = request.getParameter("m_id");
		String p_name = request.getParameter("p_name");
		String p_no = request.getParameter("p_no");
		request.setAttribute("p_no", p_no);
		request.setAttribute("p_name", p_name);
		
		forward.setRedirect(false);
		forward.setPath("todoBoardReadAction.do?p_no="+p_no+"&m_id="+m_id+"&p_name="+p_name);
		return forward;
	}

}
