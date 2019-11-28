package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.service.TodoBoardService;

public class TodoReplyInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		TodoBoardService service = TodoBoardService.getInstance();
		
		String p_no = request.getParameter("p_no");
		String p_name = request.getParameter("p_name");
		String m_id = request.getParameter("m_id");
		
		service.todoReplyInsertService(request);
		
		forward.setPath("todoBoardReadAction.do?p_no="+p_no+"&m_id="+m_id+"&p_name="+p_name);
		forward.setRedirect(false);
		
		return forward;
	}

}
