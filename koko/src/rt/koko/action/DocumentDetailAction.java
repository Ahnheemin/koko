package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.domain.DocumentDO;
import rt.koko.service.DocumentService;

public class DocumentDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DocumentService service = DocumentService.getInstance();
		ActionForward forward = new ActionForward();
		
		int doc_seq = Integer.parseInt(request.getParameter("doc_seq"));		
		DocumentDO documentDO = service.documentDetailService(doc_seq);
		
		request.setAttribute("documentDO", documentDO);
		
		forward.setPath("/document_detail.jsp");
		forward.setRedirect(false);
				
		return forward;
	}

}
