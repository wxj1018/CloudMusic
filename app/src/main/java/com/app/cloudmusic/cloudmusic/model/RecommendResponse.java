package com.app.cloudmusic.cloudmusic.model;

import java.util.List;


public class RecommendResponse extends Response {

	List<Recommend> list;

	public RecommendResponse(List<Recommend> list) {
		super();
		this.list = list;
	}

	public List<Recommend> getList() {
		return list;
	}

	public void setList(List<Recommend> list) {
		this.list = list;
	}

}
