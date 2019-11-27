package rt.koko.domain;

import java.io.Serializable;

public class MemberDO implements Serializable{
	private String m_id;
	private String m_password;
	private String m_name;
	private String m_email;
<<<<<<< HEAD
	private String m_postion;
	private String m_image;
	private String m_companyno;
	
	public MemberDO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDO(String m_id, String m_password, String m_name, String m_email, String m_postion, String m_image,
			String m_companyno) {
		super();
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_postion = m_postion;
		this.m_image = m_image;
		this.m_companyno = m_companyno;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_postion() {
		return m_postion;
	}

	public void setM_postion(String m_postion) {
		this.m_postion = m_postion;
	}

	public String getM_image() {
		return m_image;
	}

	public void setM_image(String m_image) {
		this.m_image = m_image;
	}

	public String getM_companyno() {
		return m_companyno;
	}

	public void setM_companyno(String m_companyno) {
		this.m_companyno = m_companyno;
	}
=======
	private String m_position;
	private String AuthorityNo;
	
	public MemberDO() {}

	public MemberDO(String m_id, String m_password, String m_name, String m_email, String m_position,
			String authorityNo) {
		super();
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_position = m_position;
		AuthorityNo = authorityNo;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_position() {
		return m_position;
	}

	public void setM_position(String m_position) {
		this.m_position = m_position;
	}

	public String getAuthorityNo() {
		return AuthorityNo;
	}

	public void setAuthorityNo(String authorityNo) {
		AuthorityNo = authorityNo;
	}

>>>>>>> branch 'test' of https://github.com/Ahnheemin/koko.git
	
	
}
