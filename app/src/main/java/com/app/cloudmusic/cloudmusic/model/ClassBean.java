package com.app.cloudmusic.cloudmusic.model;

public class ClassBean {

	int id;

	String infor;

	public ClassBean(int id, String infor) {
		super();
		this.id = id;
		this.infor = infor;
	}

	public ClassBean() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfor() {
		return infor;
	}

	public void setInfor(String infor) {
		this.infor = infor;
	}

	@Override
	public String toString() {
		return "ClassBean [id=" + id + ", infor=" + infor + "]";
	}

}
