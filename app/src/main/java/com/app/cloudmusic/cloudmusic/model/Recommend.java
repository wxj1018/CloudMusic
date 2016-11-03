package com.app.cloudmusic.cloudmusic.model;


public class Recommend {

	int id;

	String name;

	String music_icon;

	public Recommend(int id, String name, String music_icon) {
		super();
		this.id = id;
		this.name = name;
		this.music_icon = music_icon;
	}

	public Recommend() {
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

	public String getMusic_icon() {
		return music_icon;
	}

	public void setMusic_icon(String music_icon) {
		this.music_icon = music_icon;
	}

	@Override
	public String toString() {
		return "Recommend [id=" + id + ", name=" + name + ", music_icon="
				+ music_icon + "]";
	}

}
