package rt.koko.DAO;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import rt.koko.domain.DocumentDO;
import rt.koko.domain.DocumentSearchDO;
import rt.koko.mapper.DocumentMapper;

public class DocumentDAO {
	private static DocumentDAO dao = new DocumentDAO();

	public static DocumentDAO getInstance() {
		return dao;
	}

	// SqlSession ����
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

	// ���Է�
	public int documentInsert(DocumentDO documentDO) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			re = sqlSession.getMapper(DocumentMapper.class).documentInsert(documentDO);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		System.out.println("DAO documentInsert() : " + re);
		return re;

	}

	// �۸��
	public List<DocumentDO> documentList(DocumentSearchDO searchDO, int startRow) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<DocumentDO> list = null;

		try {
			list = sqlSession.getMapper(DocumentMapper.class).documentList(searchDO, new RowBounds(startRow, 10));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return list;
	}

	// �ڷ�� �󼼺���
	public DocumentDO documentDetail(int doc_seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		DocumentDO documentDO = null;

		try {
			documentDO = sqlSession.getMapper(DocumentMapper.class).documentDetail(doc_seq);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return documentDO;
	}

	// �� ����
	public int documentUpdate(DocumentDO documentDO) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			re = sqlSession.getMapper(DocumentMapper.class).documentUpdate(documentDO);
			// Ʈ����� ó��
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return re;

	}

	// �ۻ���
	public int documentDelete(int seq) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			re = sqlSession.getMapper(DocumentMapper.class).documentDelete(seq);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return re;
	}

	// ����¡ó��
	public int documentCount(DocumentSearchDO searchDO) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;

		try {
			re = sqlSession.getMapper(DocumentMapper.class).documentCount(searchDO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return re;
	}

}
