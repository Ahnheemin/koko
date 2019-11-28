package rt.koko.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import rt.koko.DAO.Main2DAO;
import rt.koko.domain.ProjectDO;

public class Main2Service {
	private static Main2DAO dao;
	private static Main2Service service = new Main2Service();
	
	public static Main2Service getInstance() {
		dao = Main2DAO.getInstance();
		return service;
	}
	
	public String projectManagerReadService(String p_no) throws Exception{
		return dao.projectManagerRead(p_no);
	}
	

//	public List<ProjectDO> projectReadService(HttpServletRequest request) throws Exception {
//		String m_id = request.getParameter("m_id");
//		request.setAttribute("projectList", dao.projectRead(m_id));
//		return dao.projectRead(m_id);
//	}
	
	// 권한 업데이트 서비스
	
//	public void authorityUpdateService(HttpServletRequest request) throws Exception{
//		String p_no = request.getParameter("p_no");
//		String m_id = request.getParameter("m_id");
//		System.out.println(m_id);
//		String m_admin_id = dao.projectManagerRead(p_no);
//		System.out.println(m_admin_id);
//		
//		dao.authorityUpdate(m_id, m_admin_id);
//	}
}
