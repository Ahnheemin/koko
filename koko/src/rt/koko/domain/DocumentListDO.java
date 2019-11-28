package rt.koko.domain;

import java.util.List;

public class DocumentListDO {
	private List<DocumentDO> list;
	private int requestPage;
	private int totalPageCount;
	private int startPage;
	private int endPage;
	
	public DocumentListDO() {
		// TODO Auto-generated constructor stub
	}

	public DocumentListDO(List<DocumentDO> list, int requestPage, int totalPageCount, int startPage, int endPage) {
		super();
		this.list = list;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public List<DocumentDO> getList() {
		return list;
	}

	public void setList(List<DocumentDO> list) {
		this.list = list;
	}

	public int getRequestPage() {
		return requestPage;
	}

	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
	
}
