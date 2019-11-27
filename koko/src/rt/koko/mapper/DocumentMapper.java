package rt.koko.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import rt.koko.domain.DocumentDO;
import rt.koko.domain.DocumentSearchDO;

public  interface DocumentMapper {
	int documentInsert(DocumentDO documentDO);
	List<DocumentDO> documentList(DocumentSearchDO searchDO, RowBounds row);
	DocumentDO documentDetail(int doc_seq);
	int documentUpdate(DocumentDO documentDO);
	int documentDelete(int doc_seq);
	int documentCount(DocumentSearchDO searchDO);

}
