package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = StudentController.class)
class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StudentService studentService;

    @Test
    void WhenValidInput_thenReturn201() throws Exception{
        Student student = new Student("", "s", "d", "1");

        String requestBody = objectMapper.writeValueAsString(student);


        mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)).andExpect(status().isCreated());

    }


}