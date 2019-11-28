package rt.koko.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import rt.koko.domain.TodoBoardDO;
import rt.koko.domain.TodoReplyDO;
import rt.koko.mapper.TodoBoardMapper;

public class TodoBoardDAO {
	private static final SqlSession H2DBUtil = null;
	private static TodoBoardDAO dao = new TodoBoardDAO();
	public static TodoBoardDAO getInstance() {
		return dao;
	}
	
	// dao가 mybatis-config.xml을 바로 사용할 수 없어서 객체화한다
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		// inputStream으로 빨대 꼽자
		
		try {
			in = Resources.getResourceAsStream(resource); // inputStream 연결 완료
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in); // sqlsessionFactory 만들어준다
	}
	
	// 게시글 작성시 TodoBoard에 insert
	public int todoBoardInsert(TodoBoardDO todoBoard) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(TodoBoardMapper.class).todoBoardInsert(todoBoard);
			if(re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
		}
	}
		return re;
	}
	
	// 게시글 작성시 BoardList(프로젝트별 게시글 정보) insert
	public int boardListInsert(String p_no, String b_seq) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(TodoBoardMapper.class).boardListInsert(p_no, b_seq);
			if(re>0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
		}
	}
		return re;
	}
	
	// 게시글 리스트 조회
	public List<TodoBoardDO> todoBoardListRead(String p_no, int startRow){
		List<TodoBoardDO> boardList = null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			boardList = sqlSession.getMapper(TodoBoardMapper.class).todoBoardListRead(p_no, new RowBounds(startRow, 2));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
		}
	}
		return boardList;
	}
	
	// 전체 게시글 리스트 조회
		public List<TodoBoardDO> todoBoardListRead(String p_no){
			List<TodoBoardDO> boardList = null;
			SqlSession sqlSession = getSqlSessionFactory().openSession();
			
			try {
				boardList = sqlSession.getMapper(TodoBoardMapper.class).todoBoardListRead(p_no);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(sqlSession != null) {
					sqlSession.close();
			}
		}
			return boardList;
		}
	
	// board 시퀀스 조회
	public int boardSeqRead() {
		int b_seq = -1;
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			b_seq = sqlSession.getMapper(TodoBoardMapper.class).boardSeqRead();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
		}
	}
		return b_seq;
		
	}
	
	// boardfile 시퀀스 조회	
	public int boardFileSeqRead() {
		int bf_seq = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			sqlSession.commit();
			bf_seq = sqlSession.getMapper(TodoBoardMapper.class).boardFileSeqRead();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
		}
	}
		return bf_seq;
		
	}
	
	// 게시글 관리 권한 확인 Read	
	public String boardAuthorityRead(String m_id, String p_no) {
		String a_board = "";
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			a_board = sqlSession.getMapper(TodoBoardMapper.class).boardAuthorityRead(m_id, p_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
		}
	}
		return a_board;
	}
	
	// boardFile DB에 insert	
	public int boardFileInsert(String bf_seq, String bf_name) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(TodoBoardMapper.class).boardFileInsert(bf_seq, bf_name);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
		}
	}
		return re;
	}
	
	
	// 게시글 수정	
	public void todoBoardUpdate(TodoBoardDO todoBoard) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(TodoBoardMapper.class).todoBoardUpdate(todoBoard);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
		}
	}
	}
	
	// 게시글 삭제
	public void todoBoardDelete(int b_seq) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(TodoBoardMapper.class).todoBoardDelete(b_seq);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
		}
	}
	}
	
	// 댓글 추가
	public void todoReplyInsert(TodoReplyDO todoReply) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(TodoBoardMapper.class).todoReplyInsert(todoReply);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
		}
	}
	}
	
	// 댓글 리스트 읽기
	public List<TodoReplyDO> todoReplyListRead() {
		List<TodoReplyDO> list = null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			list = sqlSession.getMapper(TodoBoardMapper.class).todoReplyListRead();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
		}
	}
		return list;
	}
	
	// 댓글 삭제
	public void todoReplyDelete(int br_seq) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(TodoBoardMapper.class).todoReplyDelete(br_seq);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
		}
	}
	}
	
	// 총 게시글 갯수
	public int boardCount(String p_no) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(TodoBoardMapper.class).boardCount(p_no);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
		}
	}
		return re;
	}
	

	
}