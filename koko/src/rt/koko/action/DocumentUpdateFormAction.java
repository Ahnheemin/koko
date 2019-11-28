package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.DAO.DocumentDAO;
import rt.koko.domain.DocumentDO;
import rt.koko.domain.DocumentListDO;
import rt.koko.service.DocumentService;

public class DocumentUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		DocumentService service = DocumentService.getInstance();
		DocumentDAO dao = DocumentDAO.getInstance();
		
		
		int doc_seq = Integer.parseInt(request.getParameter("doc_seq"));
		request.setAttribute("doc_seq", doc_seq);
		
		DocumentDO documentDO = dao.documentDetail(doc_seq);
		request.setAttribute("u", documentDO);
		
		
		forward.setPath("/document_update_form.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
