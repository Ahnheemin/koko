package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.domain.EmailListDo;
import rt.koko.service.EmailService;

public class EmailListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		EmailService emailService = EmailService.getInstance();
		
		EmailListDo emaillistdo = emailService.EmailListService(request);
		
		System.out.println(emaillistdo);
		
		request.setAttribute("emaillistdo", emaillistdo);
		
		forward.setPath("/SenderList.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
