package com.irimit.toDo.controller;

import com.irimit.toDo.data.Todo;
import com.irimit.toDo.data.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("toDos")
public class ToDoController {
    private TodoRepository repository;
    public ToDoController(TodoRepository repository) {
        this.repository = repository;
    }
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        System.out.println(todo.isCompleted());
        Todo savedTodo = repository.save(todo);
        System.out.println("saved ToDo: " + savedTodo.isCompleted());
       return savedTodo;
    }
    @GetMapping
    public List<Todo> getAll(){
        return repository.findAll();
    }
    @GetMapping("isCompleted")
    public List<Todo> getCompleted(@PathVariable boolean isCompleted){
        return repository.findByIsCompleted(isCompleted);
    }
}
