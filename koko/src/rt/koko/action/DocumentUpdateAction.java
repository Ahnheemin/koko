package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.service.DocumentService;

public class DocumentUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DocumentService service = DocumentService.getInstance();
		ActionForward forward = new ActionForward();
		
		int doc_seq = Integer.parseInt(request.getParameter("doc_seq"));
		request.setAttribute("doc_seq", doc_seq);
		
		service.documentUpdateService(request);
		
		forward.setPath("DocumentDetailAction.do?doc_seq="+doc_seq); 
		forward.setRedirect(true);
		
		
		return forward;
	}

}
