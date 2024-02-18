package com.irimit.toDo.controller;

import com.irimit.toDo.controller.ToDoNotFound.ToDoNotFound;
import com.irimit.toDo.data.ToDo;
import com.irimit.toDo.data.ToDoRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
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
    @PatchMapping("{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id, @RequestBody ToDo todoToUpdate) throws ToDoNotFound {

        ToDo existingToDo = repository.findById(id)
                .orElseThrow(ToDoNotFound::new);

        existingToDo.setIsCompleted(todoToUpdate.getIsCompleted());
        existingToDo.setWhatToDo(todoToUpdate.getWhatTODo());
        repository.save(existingToDo);

        return ResponseEntity.ok(existingToDo);
    }



}
