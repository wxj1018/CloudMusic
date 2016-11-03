package com.app.cloudmusic.cloudmusic.model;

import java.util.List;


public class RankingResponse extends Response {

	List<Ranking> list;

	public RankingResponse(List<Ranking> list) {
		super();
		this.list = list;
	}

	public List<Ranking> getList() {
		return list;
	}

	public void setList(List<Ranking> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "RankingResponse [list=" + list + "]";
	}

}
