package rt.koko.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import rt.koko.DAO.TodoBoardDAO;
import rt.koko.domain.TodoBoardDO;
import rt.koko.domain.TodoBoardPagingDO;
import rt.koko.domain.TodoReplyDO;

public class TodoBoardService {
	private static TodoBoardDAO dao;
	private static TodoBoardService service = new TodoBoardService();
	private static final int PAGE_SIZE = 2;
	
	public static TodoBoardService getInstance() {
		dao = TodoBoardDAO.getInstance();
		return service;
	}

	
	public String todoBoardInsertService(HttpServletRequest request) throws Exception {
		TodoBoardDO board = new TodoBoardDO();
		
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024; // 20MB
		
		MultipartRequest multi =
				new MultipartRequest(request, uploadPath, size,
					"utf-8", new DefaultFileRenamePolicy());
		String bf_seq = Integer.toString(service.boardFileSeqReadService());
		
		String bf_name = (String)multi.getFilesystemName("bf_name");
		
		// board안에 값 넣기
				board.setB_title(multi.getParameter("b_title"));
				board.setB_contents(multi.getParameter("b_contents"));
				board.setB_scope(multi.getParameter("b_scope"));
				board.setB_type(multi.getParameter("b_type"));
				board.setM_id(multi.getParameter("m_id"));
				board.setBf_seq(bf_seq);

				dao.boardFileInsert(bf_seq, bf_name);
				dao.todoBoardInsert(board);
				
				return bf_seq;
	}
	
	public int boardListInsertService(String p_no, String b_seq) throws Exception {

		return dao.boardListInsert(p_no, b_seq);
	}
	
	public List<TodoBoardDO> todoBoardTotalListReadService(HttpServletRequest request) throws Exception {
		String p_no = request.getParameter("p_no");
		return dao.todoBoardListRead(p_no);
	}
	
	public TodoBoardPagingDO todoBoardListReadService(HttpServletRequest request) throws Exception {
		String p_no = request.getParameter("p_no");
		
		// 페이징처리
		// 페이징당 글갯수, 총 글갯수, 총페이지수, 현재 페이지
		
		// 총글갯수
		int totalCount = dao.boardCount(p_no);
		
		// 총페이지수
		int totalPageCount = totalCount/PAGE_SIZE;
		if(totalCount%PAGE_SIZE > 0) {
			totalPageCount++;
		}
		
		// 현재페이지
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int requestPage = Integer.parseInt(pageNum);
		
		// startPage
		// startPage = 현재페이지 - (현재페이지 - 1) % 5
		int startPage = requestPage - (requestPage - 1) % 5;
		
		//endPage
		int endPage = startPage + 4;
		if(endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		//startRow
		//startRow = (현재페이지 - 1) * 페이지당 글갯수
		int startRow = (requestPage - 1) * PAGE_SIZE;

		List<TodoBoardDO> list =  dao.todoBoardListRead(p_no, startRow);
		
		TodoBoardPagingDO boardPagingModel = new TodoBoardPagingDO(list, requestPage, totalPageCount, startPage, endPage);
		return boardPagingModel;
	}
	
	///////////////// 시퀀스 조회 /////////////////
	public int boardSeqReadService()throws Exception{
		return dao.boardSeqRead();
	}
	
	public int boardFileSeqReadService()throws Exception{
		
		return dao.boardFileSeqRead();
	}
	////////////////////////////////////////////
	
	// board 글작성 권한 확인
	public String boardAuthorityReadSerivce(HttpServletRequest request) throws Exception{
		String m_id = request.getParameter("m_id");
		String p_no = request.getParameter("p_no");
		System.out.println(p_no);
		System.out.println(m_id);
		
		return dao.boardAuthorityRead(m_id, p_no);
	}
	
	// board 수정
	public void todoBoardUpdateService(HttpServletRequest request) throws Exception{
		TodoBoardDO todoBoard = new TodoBoardDO();
		String b_seq = request.getParameter("b_seq");
		todoBoard.setB_seq(Integer.parseInt(b_seq));
		todoBoard.setM_id(request.getParameter("m_id"));
		todoBoard.setB_title(request.getParameter("b_title"));
		todoBoard.setB_scope(request.getParameter("b_scope"));
		todoBoard.setB_type(request.getParameter("b_type"));
		todoBoard.setB_contents(request.getParameter("b_contents"));
		dao.todoBoardUpdate(todoBoard);
	}
	
	// board 삭제
	public void todoBoardDeleteService(HttpServletRequest request) throws Exception{
		int b_seq = Integer.parseInt(request.getParameter("b_seq"));
		dao.todoBoardDelete(b_seq);
	}
	
	// reply 추가
	public void todoReplyInsertService(HttpServletRequest request) throws Exception{
		TodoReplyDO todoReply = new TodoReplyDO();
		String b_seq = request.getParameter("b_seq");
		todoReply.setB_seq(Integer.parseInt(b_seq));
		todoReply.setBr_contents(request.getParameter("br_contents"));
		todoReply.setBr_fileNo("");	
		todoReply.setM_id(request.getParameter("m_id"));
		
		dao.todoReplyInsert(todoReply);
	}
	
	// reply 읽기
	public List<TodoReplyDO> todoReplyListReadService(HttpServletRequest request) throws Exception{

		return dao.todoReplyListRead();
	}
	
	// reply 삭제
	public void todoReplyDeleteService(HttpServletRequest request) throws Exception{
		int br_seq = Integer.parseInt(request.getParameter("br_seq"));
		dao.todoReplyDelete(br_seq);
	}
	
	// 총 게시글 갯수
	public int boardCountService(String p_no) throws Exception{
		return dao.boardCount(p_no);
	}
	
}

	
//	private int b_seq;
//	private String m_id;
//	private String bl_no;
//	private String b_fileNo;
//	private String b_title;
//	private String b_contents;
//	private String b_regdate;
//	private String b_type;
//	private String b_scope;
//	private String b_lastUpdate;
//	private String b_hitcount;

