package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.service.DAO.StudentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;
;

@Service
public class StudentService {


    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;

    }

    public Set<Student> getAllStudents(){ return studentDAO.getAllStudents();
    }

    public Student getStudentById(String id){
        return studentDAO.getStudent(id).orElseThrow();
    }

    public Student createStudent(Student student){
        logger.info("here is a createMethod... roomNr is: "+ student.roomNr());
        return studentDAO.createStudent(student);
    }

    public void updateRoomNrByStudent(String id, String roomNr){
        logger.info("here is update the roomNr ");
        studentDAO.updateRoomNrByStudent(id, roomNr);
    }

    public void deleteStudent(String id){
        logger.info("delete method is here");
        studentDAO.deleteStudent(id);
    }
}
