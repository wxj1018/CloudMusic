package com.app.cloudmusic.cloudmusic.model;

import java.util.List;

public class SongMenuResponse extends Response {
	List<SongMenu> list;

	public SongMenuResponse(List<SongMenu> list) {
		super();
		this.list = list;
	}

	public SongMenuResponse() {
		super();
	}

	public List<SongMenu> getList() {
		return list;
	}

	public void setList(List<SongMenu> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "SongMenuResponse [list=" + list + "]";
	}

}
