package rt.koko.domain;

import java.io.Serializable;

public class EmailDo implements Serializable {

    private int e_seq;                  
    private String e_receipt;     
    private String e_title;        
    private String e_contents;  
    private String e_regdate;
    private String e_file;
      
    public EmailDo() {}
     

	public EmailDo(int e_seq, String e_receipt, String e_title, String e_contents, String e_regdate,
			String e_file) {
		super();
		this.e_seq = e_seq;
		this.e_receipt = e_receipt;
		this.e_title = e_title;
		this.e_contents = e_contents;
		this.e_regdate = e_regdate;
		this.e_file = e_file;
	}


	public EmailDo(int e_seq, String e_receipt, String e_title, String e_contents, String e_regdate) {
		super();
		this.e_seq = e_seq;
		this.e_receipt = e_receipt;
		this.e_title = e_title;
		this.e_contents = e_contents;
		this.e_regdate = e_regdate;
	}

	public int getE_seq() {
		return e_seq;
	}


	public void setE_seq(int e_seq) {
		this.e_seq = e_seq;
	}


	public String getE_receipt() {
		return e_receipt;
	}


	public void setE_receipt(String e_receipt) {
		this.e_receipt = e_receipt;
	}


	public String getE_title() {
		return e_title;
	}


	public void setE_title(String e_title) {
		this.e_title = e_title;
	}


	public String getE_contents() {
		return e_contents;
	}


	public void setE_contents(String e_contents) {
		this.e_contents = e_contents;
	}


	public String getE_regdate() {
		return e_regdate;
	}


	public void setE_regdate(String e_regdate) {
		this.e_regdate = e_regdate;
	}


	public String getE_file() {
		return e_file;
	}


	public void setE_file(String e_file) {
		this.e_file = e_file;
	}


	@Override
	public String toString() {
		return "EmailDo [e_seq=" + e_seq + ", e_receipt=" + e_receipt + ", e_title="
				+ e_title + ", e_contents=" + e_contents + ", e_regdate=" + e_regdate + ", e_file=" + e_file + "]";
	}

}
