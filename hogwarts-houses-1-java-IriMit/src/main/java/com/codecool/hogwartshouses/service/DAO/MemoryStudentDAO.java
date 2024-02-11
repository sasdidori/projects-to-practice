package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.controller.StudentNotFound;
import com.codecool.hogwartshouses.model.Student;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public class MemoryStudentDAO implements StudentDAO{

    private Set<Student> students;

    public MemoryStudentDAO(Set<Student> students) {
        this.students = new HashSet<>();
    }

    @Override
    public Set<Student> getAllStudents() {
        return students;
    }

    @Override
    public Optional<Student> getStudent(String id)  {

        return students.stream().filter(student -> student.id().equals(id)).findFirst();
    }

    @Override
    public Student createStudent(Student student) {
        String studentId = UUID.randomUUID().toString();
        Student createdStudent = new Student(studentId, student.surname(), student.lastname(), student.roomNr());
        students.add(createdStudent);
        return createdStudent;
    }




    @Override
    public Student  updateRoomNrByStudent(String studentId, String roomNr){
        Optional<Student> studentToUpdate = students.stream()
                .filter(student -> student.id().equals(studentId)).findFirst();
        studentToUpdate.ifPresent(student -> student.setRoomNr(roomNr));
        return studentToUpdate.get();
    }

    @Override
    public void deleteStudent(String id) {
        students.removeIf(student -> student.id().equals(id));

    }
}
