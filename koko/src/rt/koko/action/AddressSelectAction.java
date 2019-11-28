package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.service.AddressService;

public class AddressSelectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		AddressService service = AddressService.getInstance();
		
		int ad_seq = 0;
		String s = request.getParameter("check");
		if(s!= null) {
			ad_seq = Integer.parseInt(s);
		}
		
		request.setAttribute("b", service.AddressSelectService(ad_seq));
		
		forward.setPath("../addressupdate.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
