package com.app.cloudmusic.cloudmusic.model;

public class Song {

	int id;

	String song_name;

	String song_icon_url;

	String song_url;

	int recommend_id;

	int song_menu_id;

	int singer_id;

	int class_id;

	int ranking_id;

	Singer singer;

	public Song(int id, String song_name, String song_icon_url,
			String song_url, int recommend_id, int song_menu_id, int singer_id,
			int class_id, int ranking_id, Singer singer) {
		super();
		this.id = id;
		this.song_name = song_name;
		this.song_icon_url = song_icon_url;
		this.song_url = song_url;
		this.recommend_id = recommend_id;
		this.song_menu_id = song_menu_id;
		this.singer_id = singer_id;
		this.class_id = class_id;
		this.ranking_id = ranking_id;
		this.singer = singer;
	}

	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	public Song() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSong_name() {
		return song_name;
	}

	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}

	public String getSong_icon_url() {
		return song_icon_url;
	}

	public void setSong_icon_url(String song_icon_url) {
		this.song_icon_url = song_icon_url;
	}

	public String getSong_url() {
		return song_url;
	}

	public void setSong_url(String song_url) {
		this.song_url = song_url;
	}

	public int getRecommend_id() {
		return recommend_id;
	}

	public void setRecommend_id(int recommend_id) {
		this.recommend_id = recommend_id;
	}

	public int getSong_menu_id() {
		return song_menu_id;
	}

	public void setSong_menu_id(int song_menu_id) {
		this.song_menu_id = song_menu_id;
	}

	public int getSinger_id() {
		return singer_id;
	}

	public void setSinger_id(int singer_id) {
		this.singer_id = singer_id;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public int getRanking_id() {
		return ranking_id;
	}

	public void setRanking_id(int ranking_id) {
		this.ranking_id = ranking_id;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", song_name=" + song_name
				+ ", song_icon_url=" + song_icon_url + ", song_url=" + song_url
				+ ", recommend_id=" + recommend_id + ", song_menu_id="
				+ song_menu_id + ", singer_id=" + singer_id + ", class_id="
				+ class_id + ", ranking_id=" + ranking_id + "]";
	}

}
