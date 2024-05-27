package com.learning3.firstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> listTodos = new ArrayList<Todo>();
	private static int current_id = 0;
	
	static {
		listTodos.add(new Todo(++current_id,"pepe","AWS",LocalDate.now().plusMonths(1),false));
		listTodos.add(new Todo(++current_id,"pepe","DevOps",LocalDate.now().plusMonths(2),false));
		listTodos.add(new Todo(++current_id,"pepe","Golang",LocalDate.now().plusMonths(3),false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> filtro = input -> input.getUser_name().equals(username);
		return listTodos.stream().filter(filtro).toList();
	}
	
	public void create_todo(String username,String description,LocalDate dew_date, boolean completed) {
		listTodos.add(new Todo(++current_id,username,description,dew_date,completed));
	}
	
	public void delete_todo(int id) {
		listTodos.removeIf(todo -> (todo.getId() == id));
	}
	
	public Todo getById(int id) {
	    Todo todo = null; // Initialize todo to null
	    for (Todo todo_proposal : listTodos) {
	        if (todo_proposal.getId() == id) {
	            todo = todo_proposal;
	            break; // Break the loop once the todo is found
	        }
	    }
	    return todo;
	}
	
	public void update(Todo newtodo) {
		this.delete_todo(newtodo.getId());
		listTodos.add(newtodo);
	}
	
}
