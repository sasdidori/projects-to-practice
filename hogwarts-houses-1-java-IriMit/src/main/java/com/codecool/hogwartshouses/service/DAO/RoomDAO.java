package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;

import java.util.Optional;
import java.util.Set;

public interface RoomDAO {
    public Set<Room> getAllRooms();
    public Optional<Room> getRoom(String roomNr);
    public Room createRoom(Room room);
    public boolean updateRoom(String  roomNr);
    public  void deleteRoom(String roomNr);


}