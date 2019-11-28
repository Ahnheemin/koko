package rt.koko.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.domain.TodoReplyDO;
import rt.koko.service.TodoBoardService;

public class TodoReplyReadAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		TodoBoardService service = TodoBoardService.getInstance();
		
		String p_no = request.getParameter("p_no");
		String p_name = request.getParameter("p_name");
		String m_id = request.getParameter("m_id");
		
		List<TodoReplyDO> todoReplyList = service.todoReplyListReadService(request);
		request.setAttribute("todoReplyList", todoReplyList);
		
		forward.setRedirect(false);
		forward.setPath("todoBoardReadAction.do?p_no="+p_no+"&m_id="+m_id+"&p_name="+p_name);
		
		return forward;
	}

}
