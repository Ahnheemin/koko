package rt.koko.domain;

import java.io.Serializable;

public class AddressDO implements Serializable{
	private String m_id;
	private String ad_name;
	private String ad_email;
	private String ad_company;
	private String ad_department;
	private String ad_phonenumber;
	private int ad_seq;
	
	public AddressDO() {}

	public AddressDO(String m_id, String ad_name, String ad_email, String ad_company, String ad_department,
			String ad_phonenumber, int ad_seq) {
		super();
		this.m_id = m_id;
		this.ad_name = ad_name;
		this.ad_email = ad_email;
		this.ad_company = ad_company;
		this.ad_department = ad_department;
		this.ad_phonenumber = ad_phonenumber;
		this.ad_seq = ad_seq;
	}
	
	
	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getAd_name() {
		return ad_name;
	}

	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}

	public String getAd_email() {
		return ad_email;
	}

	public void setAd_email(String ad_email) {
		this.ad_email = ad_email;
	}

	public String getAd_company() {
		return ad_company;
	}

	public void setAd_company(String ad_company) {
		this.ad_company = ad_company;
	}

	public String getAd_department() {
		return ad_department;
	}

	public void setAd_department(String ad_department) {
		this.ad_department = ad_department;
	}

	public String getAd_phonenumber() {
		return ad_phonenumber;
	}

	public void setAd_phonenumber(String ad_phonenumber) {
		this.ad_phonenumber = ad_phonenumber;
	}

	public int getAd_seq() {
		return ad_seq;
	}

	public void setAd_seq(int ad_seq) {
		this.ad_seq = ad_seq;
	}

	
	

	
	
}
