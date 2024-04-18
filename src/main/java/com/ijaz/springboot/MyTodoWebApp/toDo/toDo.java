package com.ijaz.springboot.MyTodoWebApp.toDo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
//@Table(name = "to_do")
public class toDo {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	@Size(min=10, message="need atleast 10 chars")
	private String description;
	private LocalDate targetDate;
	private boolean done;
	

	public toDo() {
		super();
	}

	public toDo(int id, String name, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "toDo [id=" + id + ", name=" + name + ", desc=" + description + ", targetDate=" + targetDate + ", done=" + done
				+ "]";
	}

}
