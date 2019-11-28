package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.service.DocumentService;

public class DocumentInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DocumentService service = DocumentService.getInstance();
		ActionForward forward = new ActionForward();
		
		service.documentInsertService(request);
		
		forward.setPath("DocumentListAction.do");
		forward.setRedirect(true);
		
		
		return forward;
	}

}
