package io.oniasfilho.pousadaapi.controller;

import io.oniasfilho.pousadaapi.dto.ClientReqDTO;
import io.oniasfilho.pousadaapi.dto.ClientResDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public interface ClientController {
    @PostMapping("/user")
    public ClientResDTO registerNewClient(ClientReqDTO client);
    @GetMapping("/user/{id}")
    public ClientResDTO getClientById(long id);
    @GetMapping("/user")
    public List<ClientResDTO> getAllClients();
    @PutMapping("/user")
    public ClientResDTO updateUser(ClientReqDTO client);
    @DeleteMapping("/user/{id}")
    public long deleteClientById(long id);
}
