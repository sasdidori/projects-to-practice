package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.controller.StudentNotFound;
import com.codecool.hogwartshouses.model.Student;

import java.util.Optional;
import java.util.Set;

public interface StudentDAO {
    public Set<Student> getAllStudents();
    public Optional<Student> getStudent(String id);
    public Student createStudent(Student student);
    public Student updateRoomNrByStudent(String id, String roomId);



    public  void deleteStudent(String id );
}
