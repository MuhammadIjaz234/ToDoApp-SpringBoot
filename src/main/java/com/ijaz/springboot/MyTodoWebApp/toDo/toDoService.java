package com.ijaz.springboot.MyTodoWebApp.toDo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class toDoService {
	private static List<toDo> toDolist = new ArrayList<>();
	private static int count = 0;
	static {
		toDolist.add(new toDo(++count, "in2mins", "learn Spring", LocalDate.now(), false));
		toDolist.add(new toDo(++count, "in2mins", "learn aws cloud practioner", LocalDate.now().plusYears(1), false));
		toDolist.add(new toDo(++count, "in2mins", "learn react js", LocalDate.now().plusYears(2), false));

	}

	public List<toDo> findbyUserName(String name) {
		Predicate<? super toDo> predicate = todo -> todo.getName().equalsIgnoreCase(name);
		return toDolist.stream().filter(predicate).toList();
	}

	public List<toDo> addToDo(String username, String desc, LocalDate targetDate, boolean done) {
		toDo todo = new toDo(++count, username, desc, targetDate, done);
		toDolist.add(todo);
		return toDolist;
	}

	public void deleteById(int id) {
		Predicate<? super toDo> predicate = todo -> todo.getId() == id;
		toDolist.removeIf(predicate);
	}

	
	public toDo findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super toDo> predicate = todo -> todo.getId() == id;
		toDo todoobj=toDolist.stream().filter(predicate).findFirst().get();
		return todoobj;
		
	}

	public void updateToDo(@Valid toDo todo) {
		// TODO Auto-generated method stub
		deleteById(todo.getId());
		toDolist.add(todo);
		
		
	}
}
