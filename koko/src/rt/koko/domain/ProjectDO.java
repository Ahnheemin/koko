package rt.koko.domain;

import java.io.Serializable;

public class ProjectDO implements Serializable{
	private String p_no;
	private String p_name;
	private String p_regdate;
	private String p_startDate;
	private String p_endDate;
	private String m_id;
	
	public ProjectDO() {}

	public ProjectDO(String p_no, String p_name, String p_regdate, String p_startDate, String p_endDate, String m_id) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_regdate = p_regdate;
		this.p_startDate = p_startDate;
		this.p_endDate = p_endDate;
		this.m_id = m_id;
	}

	public String getP_no() {
		return p_no;
	}

	public void setP_no(String p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_regdate() {
		return p_regdate;
	}

	public void setP_regdate(String p_regdate) {
		this.p_regdate = p_regdate;
	}

	public String getP_startDate() {
		return p_startDate;
	}

	public void setP_startDate(String p_startDate) {
		this.p_startDate = p_startDate;
	}

	public String getP_endDate() {
		return p_endDate;
	}

	public void setP_endDate(String p_endDate) {
		this.p_endDate = p_endDate;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	
	
}
