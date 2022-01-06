package io.oniasfilho.pousadaapi.controller.impl;

import io.oniasfilho.pousadaapi.controller.ClientController;
import io.oniasfilho.pousadaapi.dto.ClientReqDTO;
import io.oniasfilho.pousadaapi.dto.ClientResDTO;
import io.oniasfilho.pousadaapi.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientControllerImpl implements ClientController {

    ClientService service;

    public ClientControllerImpl(ClientService service) {
        this.service = service;
    }

    @PostMapping("/user")
    public ClientResDTO registerNewClient(@RequestBody ClientReqDTO client) {
        return service.registerNewClient(client);
    }

    @GetMapping("/user/{id}")
    public ClientResDTO getClientById(@PathVariable long id) {
        return service.getClientById(id);
    }

    @GetMapping("/user")
    public List<ClientResDTO> getAllClients() {
        return service.getAllClients();
    }

    @PutMapping("/user")
    public ClientResDTO updateUser(@RequestBody ClientReqDTO client) {
        return service.updateUser(client);
    }

    /*TODO alter this method to disableClientById*/
    @DeleteMapping("/user/{id}")
    public long deleteClientById(@PathVariable long id) {
        return service.deleteClientById(id);
    }
}
