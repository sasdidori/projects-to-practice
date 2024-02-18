package com.irimit.toDo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends JpaRepository <ToDo, Long>{
     List<ToDo> findByIsCompleted(boolean isCompleted);


    Optional<ToDo> findByWhatToDo(String whatToDo);

     Optional<ToDo> findById(Long id);
}
