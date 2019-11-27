package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.domain.AddressDO;
import rt.koko.service.AddressService;

public class AddressInsertAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		AddressService service = AddressService.getInstance();
		//����
		System.out.println("service::" + service);
		
		AddressDO addressDO = new AddressDO();
		
		addressDO.setAd_name(request.getParameter("ad_name"));
		addressDO.setAd_email(request.getParameter("ad_email"));
		addressDO.setAd_company(request.getParameter("ad_company"));
		addressDO.setAd_department(request.getParameter("ad_department"));
		addressDO.setAd_phonenumber(request.getParameter("ad_phonenumber"));
		
		
		service.AddressInsertService(addressDO);
		
		forward.setPath("list.do");
		forward.setRedirect(true);
		System.out.println("forward" + forward);
		
		return forward;
	}
	
	

}
