package com.learning3.firstwebapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private int id;
	
	private String username;
	
	@Size(min=10, message="At least 10 charectars")
	private String description;
	private LocalDate dew_date;
	private boolean done;
	
	public Todo() {
		
	}
	
	public Todo(int id, String user_name, String description, LocalDate dew_date, boolean done) {
		super();
		this.id = id;
		this.username = user_name;
		this.description = description;
		this.dew_date = dew_date;
		this.done = done;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", user_name=" + username + ", description=" + description + ", dew_date=" + dew_date
				+ ", done=" + done + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return username;
	}
	public void setUser_name(String user_name) {
		this.username = user_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDew_date() {
		return dew_date;
	}
	public void setDew_date(LocalDate dew_date) {
		this.dew_date = dew_date;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	
}
