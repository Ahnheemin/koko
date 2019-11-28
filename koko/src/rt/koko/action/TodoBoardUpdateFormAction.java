package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.service.TodoBoardService;

public class TodoBoardUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		String m_id = request.getParameter("m_id");
		String p_no = request.getParameter("p_no");
		String p_name = request.getParameter("p_name");
		String b_seq = request.getParameter("b_seq");
		
		request.setAttribute("b_seq", b_seq);
		request.setAttribute("p_no", p_no);
		request.setAttribute("p_name", p_name);
		
		forward.setRedirect(false);
		forward.setPath("/todoBoardUpdateForm.jsp?p_no="+p_no+"&m_id="+m_id+"&p_name="+p_name+"&b_seq="+b_seq);
		
		return forward;
	}

}
