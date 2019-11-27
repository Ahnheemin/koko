package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.domain.AddressCheckDO;
import rt.koko.service.AddressService;

public class AddressDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		AddressService service = AddressService.getInstance();
		AddressCheckDO check = new AddressCheckDO();
		
		check.setCheck(request.getParameterValues("check")); //이거..
		
		
		
		//int ad_seq = 0;
		String s = request.getParameter("check");
		System.out.println(s + "이거 체크한값");
		String[] s2 = request.getParameterValues("check"); //여러개 받아올때 그리고 name으로 받아와야한다.
		System.out.println("action에서" +s2[0] +"받아왔숩니당!!");
		
		//ad_seq = Integer.parseInt(s2[0]);
		
//		if(s != null) ad_seq = Integer.parseInt(s);
		
		//System.out.println("action에서" + ad_seq);
		service.AddressDeleteService(check);
		
		forward.setPath("list.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
