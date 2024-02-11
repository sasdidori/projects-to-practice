package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Set<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("{studentId}")
    public Student getStudentById(@PathVariable String studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PatchMapping("{studentId}/{roomNr}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateStudentById(@PathVariable String studentId, @PathVariable String roomNr){
        studentService.updateRoomNrByStudent(studentId, roomNr);
        return ResponseEntity.ok("The student is updated");
    }

    @DeleteMapping("{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteStudentById(@PathVariable String studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("The student was deleted");
    }
}
