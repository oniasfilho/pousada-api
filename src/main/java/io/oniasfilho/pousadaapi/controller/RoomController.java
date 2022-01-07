package io.oniasfilho.pousadaapi.controller;

import io.oniasfilho.pousadaapi.model.Room;

import java.util.List;

public interface RoomController {
    public Room createRoom(Room toBeRegistered);
    public Room getRoomByRoomNumber(int roomNumber);
    public List<Room> getAllRooms();
    public Room updateRoom(Room toBeUpdated);
    public int deleteRoomByRoomNumber(int room_number);
}
