package rt.koko.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import rt.koko.domain.EmailDeleteDo;
import rt.koko.domain.EmailDo;
import rt.koko.domain.EmailListSearchDo;
import rt.koko.mapper.EmailMapper;

public class EmailDAO {
	private static EmailDAO dao = new EmailDAO();
	
	public static EmailDAO getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public int insertEmail(EmailDo email) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re =  sqlSession.getMapper(EmailMapper.class).insertEmail(email);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return re;
	}
	
	public List<EmailDo> EmailSenderList(EmailListSearchDo searchDo, int startRow){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<EmailDo> Slist = null;
		
		try {
			Slist = sqlSession.getMapper(EmailMapper.class).EmailSenderList(searchDo, new RowBounds(startRow, 5));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return Slist;
	}
	
	public int countSenderList(EmailListSearchDo searchDo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		
		try {
			re = sqlSession.getMapper(EmailMapper.class).countSenderList(searchDo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return re;
	}
	
	public int emaildelete(EmailDeleteDo edelete) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(EmailMapper.class).emaildelete(edelete);
			if(re > 0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return re;
	}
}
