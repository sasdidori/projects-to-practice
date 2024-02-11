package com.codecool.hogwartshouses.model;

import java.util.Objects;

public class Student {

    public final String id;
    public final String surname;
    public final String lastname;
    public String roomNr;

    public Student(String id, String surname, String lastname, String roomNr) {
        this.id = id;
        this.surname = surname;
        this.lastname = lastname;
        this.roomNr = roomNr;
    }

    public String id() {
        return id;
    }

    public String surname() {
        return surname;
    }

    public String lastname() {
        return lastname;
    }

    public String roomNr() {
        return roomNr;
    }

    public void setRoomNr(String roomNr) {
        this.roomNr = roomNr;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", surname='" + surname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", roomNr=" + roomNr +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(roomNr, student.roomNr) &&
                Objects.equals(id, student.id) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(lastname, student.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, lastname, roomNr);
    }


}


