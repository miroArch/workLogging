package com.work.model;

public class Logging {

	private String id;
	private String loggingText;
	private String date;
	private String time;

	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoggingText() {
		return loggingText;
	}

	public void setLoggingText(String loggingText) {
		this.loggingText = loggingText;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Logging [id=" + id + ", loggingText=" + loggingText + ", date=" + date + ", time=" + time + ", user="
				+ user + "]";
	}

}
