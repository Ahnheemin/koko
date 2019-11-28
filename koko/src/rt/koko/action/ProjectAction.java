package rt.koko.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rt.koko.domain.ProjectDO;
import rt.koko.service.Main2Service;

public class ProjectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Main2Service service = Main2Service.getInstance();
		ActionForward forward = new ActionForward();
		
		// 프로젝트에 필요한 요소들 session에 저장
		HttpSession info_session = request.getSession();
		String m_id = request.getParameter("m_id");
		String p_name = request.getParameter("p_name");
		String p_no = request.getParameter("p_no");
		request.setAttribute("p_no", p_no);
		//service.authorityUpdateService(request);

		info_session.setAttribute("m_id", m_id);
		info_session.setAttribute("p_name", p_name);
		info_session.setAttribute("p_no", p_no);
		
		// 프로젝트 담당자 불러와서 저장
		String m_admin = service.projectManagerReadService(p_no);
		
		request.setAttribute("m_admin", m_admin);
		
		forward.setRedirect(true);
		forward.setPath("/TodoBoard/todoBoard/todoBoardReadAction.do?p_no="+p_no+"&m_id="+m_id+"&p_name="+p_name);
		
		return forward;
	}

}
