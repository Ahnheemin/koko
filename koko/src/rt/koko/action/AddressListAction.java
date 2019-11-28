package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.domain.AddressListDO;
import rt.koko.service.AddressService;

public class AddressListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		AddressService service = AddressService.getInstance();
		
		request.setAttribute("li", service.AddressListService(request));
		forward.setPath("../addresslist.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
