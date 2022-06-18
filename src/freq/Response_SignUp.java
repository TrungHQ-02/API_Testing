package freq;

public class Response_SignUp {
	public String code;
	public String msg;
	public String note;

	public Response_SignUp(String code, String msg, String note) {
		this.code = code;
		this.msg = msg;
		this.note = note;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
