package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(("rooms"))
public class RoomController {

    private RoomService roomService;
    public RoomController(RoomService roomService) { this.roomService = roomService;
    }

    @GetMapping
    public Set<Room> getAllRooms (){
       return roomService.getAllRooms();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Room> createRoom(@RequestBody Room room){
        Room result =  roomService.create(room);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("{roomNr}")
    public Optional<Room> getRoomByRoomNr(@PathVariable String roomNr) throws RoomNotFound {
        return roomService.findByRoomNr(roomNr);
    }
    @GetMapping("{roomNr}/students")
    public Optional<Set<String>> getStudentsInRoom(@PathVariable String roomNr) throws RoomNotFound{
        return roomService.getStudentsInRoomByRoomNr(roomNr);
    }
    @PostMapping("{roomNr}/students/{studentId}")
    public Optional <Set<String>> AddStudentToRoom(@PathVariable String roomNr,@PathVariable String studentId)
        throws RoomNotFound{
        roomService.addStudentInRoom(roomNr, studentId);
        return roomService.getStudentsInRoomByRoomNr(roomNr);
    }

    @DeleteMapping("{roomNr}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteRoomByRoomNr(@PathVariable String roomNr) {
        roomService.deleteRoom(roomNr);
        return ResponseEntity.ok("THE ROOM WAS DELETED");


    }

}
