package com.typicode.jsonplaceholder;

public class Media {
	private int mediaId;
    private String name;
    private String url;
    private User user;
    
	public Media() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Media(int mediaId, String name, String url, User user) {
		super();
		this.mediaId = mediaId;
		this.name = name;
		this.url = url;
		this.user = user;
	}
	public int getMediaId() {
		return mediaId;
	}
	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    

}
