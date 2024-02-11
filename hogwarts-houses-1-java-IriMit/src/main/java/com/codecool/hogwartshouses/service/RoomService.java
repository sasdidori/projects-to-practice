package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.controller.RoomNotFound;
import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import com.codecool.hogwartshouses.service.DAO.StudentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class RoomService {
    private static final Logger logger = LoggerFactory.getLogger(RoomService.class);

    private final RoomDAO roomDAO;


    public RoomService(RoomDAO roomDAO, StudentDAO studentDAO) {
        this.roomDAO = roomDAO;

    }

    public Set<Room> getAllRooms(){
       return roomDAO.getAllRooms();
    }

    public Room create(Room room){
        logger.info("here is create method");
        return roomDAO.createRoom(room);
    }

    public Optional<Room> findByRoomNr(String roomNr) throws RoomNotFound {
        return Optional.ofNullable(roomDAO.getRoom(roomNr).orElseThrow(RoomNotFound::new));
    }

    public Optional<Set<String>> getStudentsInRoomByRoomNr(String roomNr) throws RoomNotFound{
        return Optional.ofNullable(roomDAO.getRoom(roomNr)
                .get().getStudentsInRoom());
    }

    public Optional<Set<String>> addStudentInRoom(String roomNr, String studentId) throws RoomNotFound{
        return Optional.ofNullable(roomDAO.getRoom(roomNr)
                .get().setStudentsInRoom(studentId));
    }

    public void deleteRoom(String roomNr){
        logger.info("here is delete method");
         roomDAO.deleteRoom(roomNr);
    }





}


