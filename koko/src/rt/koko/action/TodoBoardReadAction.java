package rt.koko.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.domain.TodoBoardDO;
import rt.koko.domain.TodoBoardPagingDO;
import rt.koko.domain.TodoReplyDO;
import rt.koko.service.TodoBoardService;

public class TodoBoardReadAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		TodoBoardService service = TodoBoardService.getInstance();
		
		String p_no = request.getParameter("p_no");
		String p_name = request.getParameter("p_name");
		String m_id = request.getParameter("m_id");
		
		// 페이징 게시글 리스트
		TodoBoardPagingDO todoBoardList = service.todoBoardListReadService(request);		
		request.setAttribute("todoBoardList", todoBoardList);
		
		// 전체 게시글 리스트
		List<TodoBoardDO> list = service.todoBoardTotalListReadService(request);
		request.setAttribute("todoBoardTotalList", list);
		// 업무리포트
		int b_request = 0, b_feedback = 0, b_doing = 0, b_done = 0, b_issue = 0;
		
		for(int i = 0; i < list.size(); i++) {
			
			if((list.get(i).getB_type()).equals("b_request")) {
				b_request++;
			} else if((list.get(i).getB_type()).equals("b_feedback")) {
				b_feedback++;
			} else if((list.get(i).getB_type()).equals("b_doing")) {
				b_doing++;
			} else if((list.get(i).getB_type()).equals("b_done")) {
				b_done++;
			} else if((list.get(i).getB_type()).equals("b_issue")) {
				b_issue++;
			}
		}
		
		request.setAttribute("b_request", b_request);
		request.setAttribute("b_feedback", b_feedback);
		request.setAttribute("b_doing", b_doing);
		request.setAttribute("b_done", b_done);
		request.setAttribute("b_issue", b_issue);
		
		List<TodoReplyDO> todoReplyList = service.todoReplyListReadService(request);
		request.setAttribute("todoReplyList", todoReplyList);
		
		forward.setRedirect(false);
		forward.setPath("/main3.jsp?p_no="+p_no+"&p_name="+p_name);
		return forward;
	}

}
