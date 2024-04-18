package com.ijaz.springboot.MyTodoWebApp.toDo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class toDoController {
	@Autowired
	private toDoService todoservice;

	@RequestMapping("/list-todos")
	public String listAllToDos(ModelMap map) {
		String username = getLoggedInUserName();
		List<toDo> list = todoservice.findbyUserName(username);
		map.put("todos", list);
		return "listToDos";
	}
	

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showNewAddToDoPage(ModelMap map) {
		String username = getLoggedInUserName();
		toDo todo = new toDo(0, username, "", LocalDate.now().plusYears(1), false);
		map.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String AddToDo(ModelMap map, @Valid @ModelAttribute("todo") toDo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		} else {
			String name = getLoggedInUserName();
			todoservice.addToDo(name, todo.getDescription(), todo.getTargetDate(), false);
			return "redirect:list-todos";
		}
	}
	
	@RequestMapping("/delete-todo")
	public String deleteToDo(@RequestParam int id) {
		todoservice.deleteById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value="/update-todo" , method = RequestMethod.GET)
	public String showUpdateToDo(@RequestParam int id,ModelMap map) {
		toDo obj=todoservice.findById(id);
		map.addAttribute("todo", obj);
		return "todo";
	}
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateToDo(ModelMap map,@Valid toDo todo,BindingResult result	) {
		if (result.hasErrors()) {
			return "todo";
		} else {
			String name = getLoggedInUserName();
			todo.setName(name);
			todoservice.updateToDo(todo);
			return "redirect:list-todos";
		}
	}
	
	public String getLoggedInUserName() {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}

}
