package rt.koko.domain;

import java.io.Serializable;

public class TodoReplyDO implements Serializable{
	private int br_seq;
	private String br_contents;
	private String br_fileNo;
	private String br_lastUpdate;
	private int b_seq;
	
	public TodoReplyDO() {}

	public TodoReplyDO(int br_seq, String br_contents, String br_fileNo, String br_lastUpdate, int b_seq) {
		super();
		this.br_seq = br_seq;
		this.br_contents = br_contents;
		this.br_fileNo = br_fileNo;
		this.br_lastUpdate = br_lastUpdate;
		this.b_seq = b_seq;
	}

	public int getBr_seq() {
		return br_seq;
	}

	public void setBr_seq(int br_seq) {
		this.br_seq = br_seq;
	}

	public String getBr_contents() {
		return br_contents;
	}

	public void setBr_contents(String br_contents) {
		this.br_contents = br_contents;
	}

	public String getBr_fileNo() {
		return br_fileNo;
	}

	public void setBr_fileNo(String br_fileNo) {
		this.br_fileNo = br_fileNo;
	}

	public String getBr_lastUpdate() {
		return br_lastUpdate;
	}

	public void setBr_lastUpdate(String br_lastUpdate) {
		this.br_lastUpdate = br_lastUpdate;
	}

	public int getB_seq() {
		return b_seq;
	}

	public void setB_seq(int b_seq) {
		this.b_seq = b_seq;
	}
	
}
