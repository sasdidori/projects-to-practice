package com.irimit.toDo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository <Todo, Long>{
     List<Todo> findByIsCompleted(boolean isCompleted);
}
