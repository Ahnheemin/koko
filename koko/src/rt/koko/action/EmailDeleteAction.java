package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.domain.EmailDeleteDo;
import rt.koko.service.EmailService;

public class EmailDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		EmailService emailService = EmailService.getInstance();
		EmailDeleteDo edelete = new EmailDeleteDo();
		
		edelete.setEdelete(request.getParameterValues("edelete"));
		
		emailService.EmailDeleteService(edelete);
		
		forward.setPath("Senderlist.do");
		forward.setRedirect(true);
		return forward;
	}

}
