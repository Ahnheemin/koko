package rt.koko.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import rt.koko.DAO.LoginDAO;
import rt.koko.domain.MemberDO;

public class LoginService {
	private static LoginDAO dao;
	private static LoginService service = new LoginService();
	
	public static LoginService getInstance() {
		dao = LoginDAO.getInstance();
		return service;
	}
	
//	public boolean readIdSerivce(String m_id) {
//		String id = dao.readId(m_id)
//	}
	
	public MemberDO loginCheckService(HttpServletRequest request) throws Exception{
		String m_id = request.getParameter("m_id");
		String m_password = request.getParameter("m_password");
		MemberDO login = dao.loginCheck(m_id, m_password);
		
		HttpSession loginSession = request.getSession();
		
		if (login != null) {
			loginSession.setAttribute("login", login);
			return login;
		} else {
			return null;
		}
	}
}
