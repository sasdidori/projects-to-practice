package com.irimit.toDo.controller;

import com.irimit.toDo.data.ToDo;
import com.irimit.toDo.data.ToDoRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("toDos")
public class ToDoController {
    private ToDoRepository repository;
    public ToDoController(ToDoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ToDo> getAll(){
        return repository.findAll();
    }
    @GetMapping("isCompleted")
    public List<ToDo> getByCompleted(@PathParam("isCompleted") boolean isCompleted){
        return repository.findByIsCompleted(isCompleted);
    }
    @PostMapping
    public ToDo createTodo(@RequestBody ToDo todo){
        return repository.save(todo);
    }
//    @PatchMapping
//    public ToDo updateToDo(@RequestBody ToDo todo){
//        return repository.(todo);
//    }



}
