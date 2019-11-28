package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.service.TodoBoardService;

public class TodoBoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		TodoBoardService service = TodoBoardService.getInstance();
		
		service.todoBoardDeleteService(request);
		
		forward.setRedirect(false);
		forward.setPath("todoBoardReadAction.do");
		
		return forward;
	}

}
