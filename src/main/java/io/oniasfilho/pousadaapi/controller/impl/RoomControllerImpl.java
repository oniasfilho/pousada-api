package io.oniasfilho.pousadaapi.controller.impl;

import io.oniasfilho.pousadaapi.controller.RoomController;
import io.oniasfilho.pousadaapi.model.Room;
import io.oniasfilho.pousadaapi.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class RoomControllerImpl implements RoomController {

    private RoomService service;

    public RoomControllerImpl(RoomService service) {
        this.service = service;
    }

    public Room createRoom(@RequestBody Room toBeRegistered) {
        return service.createRoom(toBeRegistered);
    }

    public Room getRoomByRoomNumber(@PathVariable int room_number) {
        return service.getRoomByRoomNumber(room_number);
    }

    public List<Room> getAllRooms() {
        return service.getAllRooms();
    }

    public Room updateRoom(@RequestBody Room toBeUpdated) {
        return service.updateRoom(toBeUpdated);
    }

    public int deleteRoomByRoomNumber(@PathVariable int room_number) {
        service.deleteRoomByRoomNumber(room_number);
        return room_number;
    }
}
