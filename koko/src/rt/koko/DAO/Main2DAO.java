package rt.koko.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import rt.koko.domain.MemberDO;
import rt.koko.domain.ProjectDO;
import rt.koko.domain.TodoBoardDO;
import rt.koko.mapper.LoginMapper;
import rt.koko.mapper.Main2Mapper;


public class Main2DAO {
	private static Main2DAO dao = new Main2DAO();
	public static Main2DAO getInstance() {
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
	
	public String projectManagerRead(String p_no) {
		String m_admin_id = "";
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			// insertBoard = 아이디명
			m_admin_id = sqlSession.getMapper(Main2Mapper.class).projectManagerRead(p_no); // board객체 같이 넣어주면 만든 Mapper 등록
			// 트랜잭션처리
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return m_admin_id;
	}
	
	
	// 권한 업데이트
	
//	public void authorityUpdate(String m_id, String m_admin_id) {
//
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		
//		try {
//			// insertBoard = 아이디명
//			sqlSession.getMapper(Main2Mapper.class).authorityUpdate(m_id, m_admin_id); // board객체 같이 넣어주면 만든 Mapper 등록
//			// 트랜잭션처리
//			sqlSession.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(sqlSession != null) {
//				sqlSession.close();
//			}
//		}
//
//	}


}
