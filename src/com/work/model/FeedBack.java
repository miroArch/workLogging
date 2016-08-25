package com.work.model;

public class FeedBack {

	private String id;
	private String feedBackText;
	private String dateTime;

	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFeedBackText() {
		return feedBackText;
	}

	public void setFeedBackText(String feedBackText) {
		this.feedBackText = feedBackText;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "FeedBack [id=" + id + ", feedBackText=" + feedBackText + ", dateTime=" + dateTime + ", user=" + user
				+ "]";
	}

}
