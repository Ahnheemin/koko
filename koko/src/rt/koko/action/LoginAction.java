package rt.koko.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.domain.MemberDO;
import rt.koko.service.LoginService;

public class LoginAction implements Action {
	// MemberDO랑 관련 있음
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginService service = LoginService.getInstance();
		ActionForward forward = new ActionForward();
		
		MemberDO login = service.loginCheckService(request);
		
		forward.setRedirect(false);
		if (login != null) {
			forward.setPath("/main2.jsp");
		} else {
			//forward.setPath("loginFormAction.do");
			forward.setPath("/main_login_error.jsp");
		}

		return forward;
	}

}
