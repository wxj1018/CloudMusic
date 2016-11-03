package com.app.cloudmusic.cloudmusic.model;

import java.util.List;



public class ClassBeanResponse extends Response {

	List<ClassBean> list;

	public ClassBeanResponse(List<ClassBean> list) {
		super();
		this.list = list;
	}

	public ClassBeanResponse() {
		super();
	}

	public List<ClassBean> getList() {
		return list;
	}

	public void setList(List<ClassBean> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ClassBeanResponse [list=" + list + "]";
	}

}
