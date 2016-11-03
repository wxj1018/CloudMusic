package com.app.cloudmusic.cloudmusic.model;

public class Response {

	public int code=0;

	public String msg=fail;

	public static String fail = "fail";

	public static String succeed = "succeed";

	public void destroy() {
		msg = null;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
