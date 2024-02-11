package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.controller.RoomNotFound;
import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository

public class MemoryRoomDAO implements RoomDAO {

    private  Set<Room> rooms;

    public MemoryRoomDAO() {
        this.rooms = new HashSet<>();
    }

    @Override
    public Set<Room> getAllRooms() {
        return rooms;
    }

    @Override
    public Optional<Room> getRoom(String roomNr) {
            return rooms.stream().filter(room -> room.roomNr.equals(roomNr)).findFirst();
    }

    @Override
    public Room createRoom( Room room) {
        Room roomToCreate = new Room(room.getRoomNr(), room.getRoomType());
        rooms.add(roomToCreate);
        return roomToCreate;
    }

    @Override
    public boolean updateRoom(String  roomNr) {
        return true;
    }

    @Override
    public void deleteRoom(String roomNr) {
         rooms.removeIf(room -> room.roomNr.equals(roomNr));
    }
}




