package rt.koko.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.koko.domain.TodoBoardDO;
import rt.koko.service.TodoBoardService;

public class TodoBoardInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		TodoBoardService service = TodoBoardService.getInstance();
		
		// insert 하기전에 글쓸 수 있는지 권한 검사
		String a_board = service.boardAuthorityReadSerivce(request);
		System.out.println(a_board);
		boolean board_authority = false;
		if(a_board.equals("1")) {
			board_authority = true;
		}
		//boolean board_authority = (a_board.equals("0")) ? false: true;
		System.out.println(board_authority);
		
		// p_no 프로젝트 값 가져오기
		String p_no = request.getParameter("p_no");
		request.setAttribute("p_no", p_no);
		
		// board 작성 권한이 있으면
		if(board_authority) {
			service.todoBoardInsertService(request);
			//String b_seq = Integer.toString(board.getB_seq());
			String b_seq = Integer.toString(service.boardSeqReadService());
			
			// boardList insert 실행
			service.boardListInsertService(p_no, b_seq);
		}
		// list 보여주기
//		List<TodoBoardDO> todoBoardList = service.todoBoardListReadService(request);		
//		request.setAttribute("todoBoardList", todoBoardList);
		
		forward.setRedirect(false);
		forward.setPath("todoBoardReadAction.do?p_no="+p_no);
		
		return forward;
	}

}
