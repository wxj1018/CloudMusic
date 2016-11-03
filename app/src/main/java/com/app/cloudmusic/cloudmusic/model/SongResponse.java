package com.app.cloudmusic.cloudmusic.model;

import java.util.List;

public class SongResponse extends Response {
	List<Song> list;

	public SongResponse(List<Song> list) {
		super();
		this.list = list;
	}
	
	public SongResponse(){
		super();
	}

	public List<Song> getList() {
		return list;
	}

	public void setList(List<Song> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "SongResponse [list=" + list + "]";
	}
	
	

}
