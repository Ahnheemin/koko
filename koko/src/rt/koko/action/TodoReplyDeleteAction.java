package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.service.TodoBoardService;

public class TodoReplyDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		TodoBoardService service = TodoBoardService.getInstance();
		
		service.todoReplyDeleteService(request);
		
		forward.setRedirect(false);
		forward.setPath("todoBoardReadAction.do");
		
		return forward;
	}

}
