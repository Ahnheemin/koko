package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.domain.AddressDO;
import rt.koko.service.AddressService;

public class AddressUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		AddressService service = AddressService.getInstance();
		
		AddressDO addressDO = new AddressDO();
		int ad_seq = 0;
		String s = request.getParameter("ad_seq");
		if(s != null) ad_seq = Integer.parseInt(s);
		addressDO.setAd_seq(ad_seq);
		System.out.println(ad_seq + "耳�耳�諛쏆븯�떦");
		addressDO.setAd_name(request.getParameter("ad_name"));
		addressDO.setAd_email(request.getParameter("ad_email"));
		addressDO.setAd_company(request.getParameter("ad_company"));
		addressDO.setAd_department(request.getParameter("ad_department"));
		addressDO.setAd_phonenumber(request.getParameter("ad_phonenumber"));
		
		service.AddressUpdateService(addressDO);
		
		forward.setPath("list.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
