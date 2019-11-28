package rt.koko.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.domain.DocumentListDO;
import rt.koko.service.DocumentService;

public class DocumentListAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      DocumentService service = DocumentService.getInstance();
      ActionForward forward = new ActionForward();
      
      DocumentListDO listModelDO = service.documentListService(request);
      request.setAttribute("listModelDO", listModelDO);
      
      forward.setPath("/document_list.jsp");
      forward.setRedirect(false);
      
      return forward;
   }

}