package rt.koko.DAO;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import rt.koko.domain.MemberDO;
import rt.koko.mapper.LoginMapper;
import rt.koko.mapper.TodoListMapper;

public class LoginDAO {
	private static LoginDAO dao = new LoginDAO();
	public static LoginDAO getInstance() {
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
	
//	public String readId(String m_id) {
//		// 우리가 필요한건 SqlSession
//		// SqlSession을 구해보자
//		
//		String id = "";
//		System.out.println("readIdDAO");
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		
//		try {
//			// insertBoard = 아이디명
//			id = sqlSession.getMapper(TodoListMapper.class).readId(m_id); // board객체 같이 넣어주면 만든 Mapper 등록
//			// 트랜잭션처리
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(sqlSession != null) {
//				sqlSession.close();
//			}
//		}
//		
//		return id;
//	}
//	
//	public LoginDO readPassWord(String m_password) {
//		// 우리가 필요한건 SqlSession
//		// SqlSession을 구해보자
//		
//		LoginDO login = null;
//		System.out.println("readPassWord");
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		
//		try {
//			// insertBoard = 아이디명
//			login = sqlSession.getMapper(TodoListMapper.class).readPassWord(m_password); // board객체 같이 넣어주면 만든 Mapper 등록
//			// 트랜잭션처리
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(sqlSession != null) {
//				sqlSession.close();
//			}
//		}
//		
//		return login;
//	}
	
	public MemberDO loginCheck(String m_id, String m_password) {
		MemberDO login = null;
		System.out.println("loginCheck");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			// insertBoard = 아이디명
			login = sqlSession.getMapper(LoginMapper.class).loginCheck(m_id, m_password); // board객체 같이 넣어주면 만든 Mapper 등록
			// 트랜잭션처리
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return login;
	}
}
