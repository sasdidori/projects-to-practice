package com.irimit.toDo.data;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ToDoRepositoryTest {

    @Autowired
    ToDoRepository toDoRepository;

    ToDo toDo1 = new ToDo("sit", true);
    ToDo toDo2 = new ToDo("eat", false);
    @BeforeEach
    void saveToDo(){
        toDoRepository.save(toDo1);
        toDoRepository.save(toDo2);

    }

    @AfterEach
    void deleteToDo(){
        toDoRepository.delete(toDo1);
        toDoRepository.delete(toDo2);
    }

    @Test
    void findByIsCompleted() {
        List<ToDo> resultToDosTrue = toDoRepository.findByIsCompleted(true);
        assertEquals(List.of(toDo1), resultToDosTrue);
        List<ToDo> resultToDosFalse = toDoRepository.findByIsCompleted(false);
        assertEquals(List.of(toDo2), resultToDosFalse);

    }
    @Test
    void findByWhatToDo() {
        String whatTodoToFind = "sit";
        Optional<ToDo> foundedToDo = toDoRepository.findByWhatToDo(whatTodoToFind);
        assertEquals(whatTodoToFind, foundedToDo.get().getWhatTODo());
    }
    @Test
    void findByWhatToDoNotFound() {
        String whatTodoToFind = "puh";
        Optional<ToDo> foundedToDo = toDoRepository.findByWhatToDo(whatTodoToFind);
        assertTrue(foundedToDo.isEmpty());
    }

    @Test
    void findById(){
        Long id = toDo1.getId();
        ToDo resultToDo = toDoRepository.findById(id).orElseThrow();

        assertEquals(toDo1, resultToDo );
    }
}