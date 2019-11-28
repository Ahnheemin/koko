package rt.koko.domain;

import java.io.Serializable;
import java.util.List;

public class EmailListDo implements Serializable{
	private List<EmailDo> Slist;
	private int requestPage;
	private int totalPageCount;
	private int startPage;
	private int endPage;
	
	public EmailListDo() {}

	public EmailListDo(List<EmailDo> slist, int requestPage, int totalPageCount, int startPage, int endPage) {
		super();
		this.Slist = slist;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public List<EmailDo> getSlist() {
		return Slist;
	}

	public void setSlist(List<EmailDo> slist) {
		this.Slist = slist;
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
