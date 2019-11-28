package rt.koko.domain;

public class AddressSearchDO {
	private String[] area;
	private String searchkey;
	
	public AddressSearchDO() {}

	public AddressSearchDO(String[] area, String searchkey) {
		super();
		this.area = area;
		this.searchkey = searchkey;
	}

	public String[] getArea() {
		return area;
	}

	public void setArea(String[] area) {
		this.area = area;
	}

	public String getSearchkey() {
		return searchkey;
	}

	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}
	
}
