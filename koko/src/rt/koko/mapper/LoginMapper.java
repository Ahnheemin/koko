package rt.koko.mapper;

import java.util.List;

import rt.koko.domain.MemberDO;
import rt.koko.domain.ProjectDO;

public interface LoginMapper {
	MemberDO loginCheck(String m_id, String m_password);
	List<ProjectDO> projectRead(String m_id);
}
