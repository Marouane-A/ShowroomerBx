package com.typicode.jsonplaceholder;

import java.util.Date;


public class Comment extends Interaction {
	
    private Date date;
    private String text;
    
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	@Override
	public String toString() {
		return "Comment [  date=" + date + ", text=" + text + ", toString()="
				+ super.toString() + "]";
	}


	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
    
}
