package com.ijaz.springboot.MyTodoWebApp.toDo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface toDoRepository extends JpaRepository<toDo, Integer>{
	
	public List<toDo> findByName(String name);

}
