package rt.koko.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import rt.koko.domain.EmailDeleteDo;
import rt.koko.domain.EmailDo;
import rt.koko.domain.EmailListSearchDo;

public interface EmailMapper {
	int insertEmail(EmailDo email);
	List<EmailDo> EmailSenderList(EmailListSearchDo searchDo, RowBounds row);
	int countSenderList(EmailListSearchDo searchDo);
	int emaildelete(EmailDeleteDo edelete);
}
