package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("/main3.jsp");
		
		return forward;
	}

}
