package com.app.cloudmusic.cloudmusic.model;

public class Ranking {

	int id;

	String name;

	String icon_url;

	public Ranking(int id, String name, String icon_url) {
		super();
		this.id = id;
		this.name = name;
		this.icon_url = icon_url;
	}

	public Ranking() {
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

	public String getIcon_url() {
		return icon_url;
	}

	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}

	@Override
	public String toString() {
		return "Ranking [id=" + id + ", name=" + name + ", icon_url="
				+ icon_url + "]";
	}
	
	

}
