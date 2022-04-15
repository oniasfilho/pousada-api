package io.oniasfilho.pousadaapi.controller;

import io.oniasfilho.pousadaapi.model.Room;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/room")
public interface RoomController {
    @PostMapping
    public Room createRoom(Room toBeRegistered);
    @GetMapping("/{room_number}")
    public Room getRoomByRoomNumber(int roomNumber);
    @GetMapping
    public List<Room> getAllRooms();
    @PutMapping
    public Room updateRoom(Room toBeUpdated);
    @DeleteMapping("/{room_number}")
    public int deleteRoomByRoomNumber(int room_number);
}
