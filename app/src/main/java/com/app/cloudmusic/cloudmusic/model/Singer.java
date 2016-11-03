package com.app.cloudmusic.cloudmusic.model;

public class Singer {

	int id;

	String name;

	String introduce;

	String singer_icon_url;

	public Singer(int id, String name, String introduce, String singer_icon_url) {
		super();
		this.id = id;
		this.name = name;
		this.introduce = introduce;
		this.singer_icon_url = singer_icon_url;
	}

	public Singer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getSinger_icon_url() {
		return singer_icon_url;
	}

	public void setSinger_icon_url(String singer_icon_url) {
		this.singer_icon_url = singer_icon_url;
	}

	@Override
	public String toString() {
		return "Singer [id=" + id + ", name=" + name + ", introduce="
				+ introduce + ", singer_icon_url=" + singer_icon_url + "]";
	}

}
