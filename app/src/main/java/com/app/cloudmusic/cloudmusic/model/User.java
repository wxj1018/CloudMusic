package com.app.cloudmusic.cloudmusic.model;


public class User extends Response {

	int id;

	String name;

	String password;

	String nickname;

	String birthday;

	int sex;

	String phone;

	public User(int id, String name, String password, String nickname,
			String birthday, int sex, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.nickname = nickname;
		this.birthday = birthday;
		this.sex = sex;
		this.phone = phone;
	}

	public User() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", nickname=" + nickname + ", birthday=" + birthday
				+ ", sex=" + sex + ", phone=" + phone + "]";
	}

}
