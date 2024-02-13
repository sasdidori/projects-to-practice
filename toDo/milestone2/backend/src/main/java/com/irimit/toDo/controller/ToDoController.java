package com.irimit.toDo.controller;

import com.irimit.toDo.data.Todo;
import com.irimit.toDo.data.TodoRepository;
import jakarta.websocket.server.PathParam;
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
       return repository.save(todo);
    }
    @GetMapping
    public List<Todo> getAll(){
        return repository.findAll();
    }
    @GetMapping("isCompleted")
    public List<Todo> getByCompleted(@PathParam("isCompleted") boolean isCompleted){
        return repository.findByIsCompleted(isCompleted);
    }
}
