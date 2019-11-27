package rt.koko.mapper;

import rt.koko.domain.MemberDO;

public interface LoginMapper {
	MemberDO loginCheck(String m_id, String m_password);
}
