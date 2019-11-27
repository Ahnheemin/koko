package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.service.DocumentService;

public class DocumentDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DocumentService service = DocumentService.getInstance();
		ActionForward forward = new ActionForward();
		
		int doc_seq = Integer.parseInt(request.getParameter("doc_seq"));
		
		service.documentDeleteService(doc_seq);
		
		forward.setPath("DocumentListAction.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
