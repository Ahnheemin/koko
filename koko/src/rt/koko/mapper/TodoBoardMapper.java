package rt.koko.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import rt.koko.domain.MemberDO;
import rt.koko.domain.TodoBoardDO;
import rt.koko.domain.TodoReplyDO;

public interface TodoBoardMapper {
//	String readId(String m_id);
//	LoginDO readPassWord(String m_password);
	
	int todoBoardInsert(TodoBoardDO todoBoard);
	int boardListInsert(String p_no, String b_seq);
	List<TodoBoardDO> todoBoardListRead(String p_no, RowBounds rowbounds);
	List<TodoBoardDO> todoBoardListRead(String p_no);
	int boardSeqRead();
	int boardFileSeqRead();
	String boardAuthorityRead(String m_id, String p_no);
	int boardFileInsert(String bf_seq, String bf_name);
	
	// 게시글 수정
	int todoBoardUpdate(TodoBoardDO todoBoard);
	// 게시글  삭제
	int todoBoardDelete(int b_seq);
	// 댓글 추가
	int todoReplyInsert(TodoReplyDO todoReply);
	// 댓글 리스트 읽기
	List<TodoReplyDO> todoReplyListRead();
	int todoReplyDelete(int br_seq);
	
	// 총 게시글 갯수
	int boardCount(String p_no);
}
