package com.codecool.hogwartshouses.model;

import java.util.HashSet;
import java.util.Set;

public class Room {

    public String roomNr;
    private final RoomType roomType;
    private boolean isFreePlace;
    private int freePlaces;
    private Set<String> studentsInRoom ;

        public Room(String roomNr, RoomType roomType) {
        this.roomNr = roomNr;
        this.roomType = roomType;
        this.studentsInRoom = new HashSet<>();
        this.freePlaces = switch (roomType){
            case NORMAL -> 3;
            case DOUBLE -> 2;
            case SINGLE -> 1;
        };
    }

    public int getFreePlaces() {
        return freePlaces;
    }


    public String getRoomNr() {
        return roomNr;
    }

    public void setRoomNr(String roomNr) {
        this.roomNr = roomNr;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public Set<String> getStudentsInRoom() {
        return studentsInRoom;
    }

    public Set<String> setStudentsInRoom(String studentId){
        studentsInRoom.add(studentId);
        if(isFreePlace){
            freePlaces--;
        }
        return studentsInRoom;

    }

    public boolean isFreePlace(){
        switch (roomType){
            case SINGLE -> {
                return studentsInRoom.isEmpty();
            }
            case DOUBLE -> {

                return studentsInRoom.size() < 2;
            }
            case NORMAL -> {

                return studentsInRoom.size() < 3;
            }
            default -> {
                return studentsInRoom.isEmpty();
            }
        }
    }

}




