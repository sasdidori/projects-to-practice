package com.irimit.toDo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository <ToDo, Long>{
     List<ToDo> findByIsCompleted(boolean isCompleted);
     ToDo update(ToDo todo);

     ToDo findByWhatToDo(String whatToDo);
}
