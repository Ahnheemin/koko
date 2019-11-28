package rt.koko.domain;

import java.io.Serializable;

public class DocumentDO implements Serializable{
	private int doc_seq;
	private String doc_title;
	private String doc_content;
	private String doc_file;
	private String doc_regdate;
	private String m_id;
	
	public DocumentDO() {
		// TODO Auto-generated constructor stub
	}

	public DocumentDO(int doc_seq, String doc_title, String doc_content, String doc_file, String doc_regdate,
			String m_id) {
		super();
		this.doc_seq = doc_seq;
		this.doc_title = doc_title;
		this.doc_content = doc_content;
		this.doc_file = doc_file;
		this.doc_regdate = doc_regdate;
		this.m_id = m_id;
	}

	public int getDoc_seq() {
		return doc_seq;
	}

	public void setDoc_seq(int doc_seq) {
		this.doc_seq = doc_seq;
	}

	public String getDoc_title() {
		return doc_title;
	}

	public void setDoc_title(String doc_title) {
		this.doc_title = doc_title;
	}

	public String getDoc_content() {
		return doc_content;
	}

	public void setDoc_content(String doc_content) {
		this.doc_content = doc_content;
	}

	public String getDoc_file() {
		return doc_file;
	}

	public void setDoc_file(String doc_file) {
		this.doc_file = doc_file;
	}

	public String getDoc_regdate() {
		return doc_regdate;
	}

	public void setDoc_regdate(String doc_regdate) {
		this.doc_regdate = doc_regdate;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
}
