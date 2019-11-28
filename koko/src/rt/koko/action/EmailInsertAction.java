package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.service.EmailService;

public class EmailInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		EmailService emailService = EmailService.getInstance();
		emailService.emailInsertService(request, response);
		forward.setPath("Senderlist.do");
		forward.setRedirect(true);
		return forward;
	}

}
