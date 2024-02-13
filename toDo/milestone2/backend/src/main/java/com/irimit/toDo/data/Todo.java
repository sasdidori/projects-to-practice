package com.irimit.toDo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private long id;
    private String whatTodo;
    private boolean isCompleted;

    public Todo() {

    }

    public String getWhatTodo() {
        return whatTodo;
    }

    public void setWhatTodo(String whatTodo) {
        this.whatTodo = whatTodo;
    }

    public boolean isCompleted() {
        return isCompleted;
    }


    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Todo(String whatTodo, boolean isCompleted) {
        this.whatTodo = whatTodo;
        this.isCompleted = isCompleted;
    }
}
