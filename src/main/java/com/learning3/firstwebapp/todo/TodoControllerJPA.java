package com.learning3.firstwebapp.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learning3.firstwebapp.login.LoginController;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

	private LoginController loginController;
	private TodoRepository todos;

	public TodoControllerJPA(TodoRepository todos, LoginController loginController) {
		super();
		this.todos = todos;
		this.loginController = loginController;
	}
	@RequestMapping("todo-delete")
	public String deleteTodo(@RequestParam int id) {
		this.todos.deleteById(id);
		return "redirect:todo-list";
	}
	
	@RequestMapping(value="edit-todo", method=RequestMethod.GET)
	public String editTodoView(@RequestParam int id, ModelMap model) {
		Todo todo = todos.getById(id);
		model.put("todo", todo);
		return "edit-todo";
	}
	
	@RequestMapping(value="edit-todo", method=RequestMethod.POST)
	public String editTodo(@Valid Todo todo, BindingResult result) {
		todo.setUser_name(loginController.getUsernameAuthUser());
		this.todos.save(todo);
		return "redirect:todo-list";
	}
	
	@RequestMapping("todo-list")
	public String showTodos(ModelMap model) {
		model.put("todos", todos.findByUsername(loginController.getUsernameAuthUser()));
		
		return "todo-list";
	}
	
	@RequestMapping(value="addTodo",method=RequestMethod.GET)
	public String addTodo(ModelMap model) {
		Todo todo = new Todo(0,"","",LocalDate.now(),false);
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value="addTodo",method=RequestMethod.POST)
	public String createTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addTodo";
		}
		todo.setUser_name(loginController.getUsernameAuthUser());
		todos.save(todo);
		return "redirect:todo-list";
	}
	

}
