package rt.koko.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import rt.koko.domain.AddressCheckDO;
import rt.koko.domain.AddressDO;
import rt.koko.domain.AddressSearchDO;
import rt.koko.mapper.AddressMapper;

public class AddressDAO {
	private static AddressDAO dao = new AddressDAO();

	public static AddressDAO getInstance() {
		return dao;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream is = null;

		try {
			is = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new SqlSessionFactoryBuilder().build(is);
	} // ����

	// 1. 주소록 등록
	public int addressInsert(AddressDO addressDO) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		int x = -1;
		try {
			x = sqlSession.getMapper(AddressMapper.class).addressInsert(addressDO);
			if (x > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		System.out.println("DAO");
		return x;
	}

	// 2.주소록 보기
	public List<AddressDO> addressList(AddressSearchDO addressSearchDO,int StartRow) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<AddressDO> list = null;

		try {
			list = sqlSession.getMapper(AddressMapper.class).addressList(addressSearchDO, new RowBounds(StartRow,10));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return list;
	}

	// 3.주소록 삭제
	public int addressDelete(AddressCheckDO check) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		System.out.println("다오왔습니당." + check );
		int x = -1;
		try {
			x = sqlSession.getMapper(AddressMapper.class).addressDelete(check);

			if (x > 0)
				sqlSession.commit();
			else
				sqlSession.rollback();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return x;
	}
	
	//4.addressSelect 주소록
	public AddressDO addressSelect(int ad_seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		AddressDO addressdo = null;
		try {
			addressdo = sqlSession.getMapper(AddressMapper.class).addressSelect(ad_seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return addressdo;
	}
	
	//5.addressUpdate 주소록
	public int addressUpdate(AddressDO addressDO) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		int x = -1;
		
		try {
			x = sqlSession.getMapper(AddressMapper.class).addressUpdate(addressDO);
			
			if(x > 0) sqlSession.commit();
			else sqlSession.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return x;
	}
	
	//페이징처리
	public int addressCount(AddressSearchDO addressSearchDO) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int x = -1;
		try {
			x = sqlSession.getMapper(AddressMapper.class).addressCount(addressSearchDO);		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return x;
	}

}
