package com.app.cloudmusic.cloudmusic.model;

public class SongMenu {

	int id;

	String name;

	String menu_icon_url;

	public SongMenu(int id, String name, String menu_icon_url) {
		super();
		this.id = id;
		this.name = name;
		this.menu_icon_url = menu_icon_url;
	}
	
	public SongMenu(){
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

	public String getMenu_icon_url() {
		return menu_icon_url;
	}

	public void setMenu_icon_url(String menu_icon_url) {
		this.menu_icon_url = menu_icon_url;
	}

	@Override
	public String toString() {
		return "SongMenu [id=" + id + ", name=" + name + ", menu_icon_url="
				+ menu_icon_url + "]";
	}
	
	

}
