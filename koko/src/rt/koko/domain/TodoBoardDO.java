package rt.koko.domain;

import java.io.Serializable;

public class TodoBoardDO implements Serializable {
	private int b_seq;
	private String m_id;
	private String bl_no;
	private String bf_seq;
	private String b_title;
	private String b_contents;
	private String b_regdate;
	private String b_type;
	private String b_scope;
	private String b_lastUpdate;
	private String b_hitcount;
	private String bf_name;
	
	public TodoBoardDO() {}
	
	

	public TodoBoardDO(int b_seq, String m_id, String bl_no, String bf_seq, String b_title, String b_contents,
			String b_regdate, String b_type, String b_scope, String b_lastUpdate, String b_hitcount, String bf_name) {
		super();
		this.b_seq = b_seq;
		this.m_id = m_id;
		this.bl_no = bl_no;
		this.bf_seq = bf_seq;
		this.b_title = b_title;
		this.b_contents = b_contents;
		this.b_regdate = b_regdate;
		this.b_type = b_type;
		this.b_scope = b_scope;
		this.b_lastUpdate = b_lastUpdate;
		this.b_hitcount = b_hitcount;
		this.bf_name = bf_name;
	}



	public TodoBoardDO(int b_seq, String m_id, String bl_no, String bf_seq, String b_title, String b_contents,
			String b_regdate, String b_type, String b_scope, String b_lastUpdate, String b_hitcount) {
		super();
		this.b_seq = b_seq;
		this.m_id = m_id;
		this.bl_no = bl_no;
		this.bf_seq = bf_seq;
		this.b_title = b_title;
		this.b_contents = b_contents;
		this.b_regdate = b_regdate;
		this.b_type = b_type;
		this.b_scope = b_scope;
		this.b_lastUpdate = b_lastUpdate;
		this.b_hitcount = b_hitcount;
	}

	public TodoBoardDO(String m_id, String b_title, String b_contents, String b_type, String b_scope, String bf_seq) {
		super();
		this.m_id = m_id;
		this.bf_seq = bf_seq;
		this.b_title = b_title;
		this.b_contents = b_contents;
		this.b_type = b_type;
		this.b_scope = b_scope;
	}
	
	

	public TodoBoardDO(int b_seq, String m_id, String b_title, String b_contents, String b_regdate) {
		super();
		this.b_seq = b_seq;
		this.m_id = m_id;
		this.b_title = b_title;
		this.b_contents = b_contents;
		this.b_regdate = b_regdate;
	}



	public int getB_seq() {
		return b_seq;
	}

	public void setB_seq(int b_seq) {
		this.b_seq = b_seq;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getBl_no() {
		return bl_no;
	}

	public void setBl_no(String bl_no) {
		this.bl_no = bl_no;
	}

	public String getBf_seq() {
		return bf_seq;
	}

	public void setBf_seq(String bf_seq) {
		this.bf_seq = bf_seq;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_contents() {
		return b_contents;
	}

	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}

	public String getB_regdate() {
		return b_regdate;
	}

	public void setB_regdate(String b_regdate) {
		this.b_regdate = b_regdate;
	}

	public String getB_type() {
		return b_type;
	}

	public void setB_type(String b_type) {
		this.b_type = b_type;
	}

	public String getB_scope() {
		return b_scope;
	}

	public void setB_scope(String b_scope) {
		this.b_scope = b_scope;
	}

	public String getB_lastUpdate() {
		return b_lastUpdate;
	}

	public void setB_lastUpdate(String b_lastUpdate) {
		this.b_lastUpdate = b_lastUpdate;
	}

	public String getB_hitcount() {
		return b_hitcount;
	}

	public void setB_hitcount(String b_hitcount) {
		this.b_hitcount = b_hitcount;
	}

	public String getBf_name() {
		return bf_name;
	}

	public void setBf_name(String bf_name) {
		this.bf_name = bf_name;
	}

	
	
}
