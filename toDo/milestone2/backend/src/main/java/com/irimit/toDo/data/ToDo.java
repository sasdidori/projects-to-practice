package com.irimit.toDo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ToDo {

    @Id
    @GeneratedValue
    private long id;
    private String whatToDo;
    private boolean isCompleted;

    public ToDo() {

    }

    public String getWhatTODo() {
        return whatToDo ;
    }

    public void setWhatToDo(String whatToDo) {
        this.whatToDo = whatToDo;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }


    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public ToDo(String whatToDo, boolean isCompleted) {
        this.whatToDo = whatToDo;
        this.isCompleted = isCompleted;
    }
}
