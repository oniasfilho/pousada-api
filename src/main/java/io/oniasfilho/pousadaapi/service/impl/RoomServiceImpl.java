package io.oniasfilho.pousadaapi.service.impl;

import io.oniasfilho.pousadaapi.model.Room;
import io.oniasfilho.pousadaapi.repository.ClientRepository;
import io.oniasfilho.pousadaapi.repository.RoomRepository;
import io.oniasfilho.pousadaapi.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository repo;

    public RoomServiceImpl(RoomRepository repo) {
        this.repo = repo;
    }

    public Room createRoom(Room toBeRegistered) {
        return repo.save(toBeRegistered);
    }

    public Room getRoomByRoomNumber(int roomNumber) {
        try{
            return repo.findById(roomNumber).get();
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quarto inexistente");
        }
    }

    public List<Room> getAllRooms() {
        return repo.findAll();
    }

    public Room updateRoom(Room toBeUpdated) {
        try{
            Room oldRoom = repo.findById(toBeUpdated.getRoom_number()).get();
            oldRoom.setSector(toBeUpdated.getSector());
            oldRoom.setMaximum_capacity(toBeUpdated.getMaximum_capacity());
            oldRoom.setType(toBeUpdated.getType());
            return repo.save(oldRoom);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quarto inexistente");
        }
    }

    public int deleteRoomByRoomNumber(int room_number) {
        repo.deleteById(room_number);
        return room_number;
    }
}
