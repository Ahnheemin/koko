package rt.koko.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import rt.koko.domain.AddressCheckDO;
import rt.koko.domain.AddressDO;
import rt.koko.domain.AddressSearchDO;

public interface AddressMapper {
	int addressInsert(AddressDO addressDO);
	List<AddressDO> addressList(AddressSearchDO addressSearchDO, RowBounds row); //2.addressList
	int addressDelete(AddressCheckDO check); //3.addressDelete
	AddressDO addressSelect(int ad_seq);//4.addressSelect
	int addressUpdate(AddressDO addressDO);//5.addressUpdate
	int addressCount(AddressSearchDO addressSearchDO);//6.∆‰¿Ã¬°√≥∏Æ
	
}
