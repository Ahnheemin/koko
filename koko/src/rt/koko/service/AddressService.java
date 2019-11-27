package rt.koko.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import rt.koko.DAO.AddressDAO;
import rt.koko.domain.AddressCheckDO;
import rt.koko.domain.AddressDO;
import rt.koko.domain.AddressListDO;
import rt.koko.domain.AddressSearchDO;

public class AddressService {
	private static AddressService service = new AddressService();
	private static AddressDAO dao;
	private static final int PAGE_SIZE = 10; // 페이지 5 상수로 만들어줌

	public static AddressService getInstance() {
		dao = AddressDAO.getInstance();
		return service;
	}

	public int AddressInsertService(AddressDO addressDO) {
		int x = dao.addressInsert(addressDO);
		return x;
	}

	public AddressListDO AddressListService(HttpServletRequest request) throws Exception {

		AddressSearchDO addressSearchDO = new AddressSearchDO();
		HttpSession session = request.getSession();

		if (request.getParameterValues("area") != null) {
			session.removeAttribute("search");// 초기화
			addressSearchDO.setArea(request.getParameterValues("area"));
			addressSearchDO.setSearchkey("%" + request.getParameter("searchkey") + "%");
			session.setAttribute("search", addressSearchDO);
			System.out.println(addressSearchDO);
		} else if (session.getAttribute("search") != null) {
			addressSearchDO = (AddressSearchDO) session.getAttribute("search");
		}

		// 페이징 처리 로직
		// 1. 페이지 당 글갯수->상수로 위에 선언해줬음 : 총 글갯수(DAO.카운트보드), 총 페이지수, 현재페이지
		// startPage,endPage,startRow,endRow

		// 다오2에서 입력했던 총 글갯수
		int totalCount = dao.addressCount(addressSearchDO);
		System.out.println("totalCount : " + totalCount);
		// 총페이지수
		int totalPageCount = totalCount / PAGE_SIZE; // 근데 나머지가 0이상일 수 있으니까
		if (totalCount % PAGE_SIZE > 0) {
			totalPageCount++; // 페이지를 하나 더 증가시켜 줌으로써 모든 페이지가 다 나올 수 있게 해준다.
		}
		System.out.println("ss" + totalPageCount);
		// 현재페이지
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int requestPage = Integer.parseInt(pageNum);

		// startPage
		// 공식이 있다. startPage = 현재페이지 - (현재페이지 -1) % 5 =>우리가 5페이지씩 보게할거니까.. 10페이지씩 보려고하면
		// %10하면됨
		int startPage = requestPage - (requestPage - 1) % 5;
		// endPage
		int endPage = startPage + 4; // endpage는 총페이지 수(totalPageCount)를 넘길 수 없음
		if (endPage > totalPageCount) {
			endPage = totalPageCount; // 조건:endPage가 totalPage보다 크면 totalPage로 만들어줘야한다.
		}

		// startRow
		// startRow = (현재페이지 - 1) - 페이지 당 글갯수
		int startRow = (requestPage - 1) * PAGE_SIZE;
		
		
		// List<AddressDO> addressList = dao.addressList(addressSearchDO);
		//검색처리만할때
		//addressListDO.setList(dao.addressList(addressSearchDO));
		//return addressListDO;
		List<AddressDO> list = dao.addressList(addressSearchDO, startRow);
		AddressListDO addressListDO = new AddressListDO(list, requestPage, totalPageCount, startPage, endPage);
		return addressListDO;
	}

	public int AddressDeleteService(AddressCheckDO check) {
		System.out.println("delete 입니당");
		return dao.addressDelete(check);
	}

	public AddressDO AddressSelectService(int ad_seq) {
		System.out.println("AddressSelectService입니당");
		return dao.addressSelect(ad_seq);
	}

	public int AddressUpdateService(AddressDO addressDO) {
		System.out.println("AddressUpdateService입니당");
		int x = dao.addressUpdate(addressDO);
		return x;
	}

}
