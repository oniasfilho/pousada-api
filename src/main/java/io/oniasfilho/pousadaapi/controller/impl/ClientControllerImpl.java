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

    public ClientResDTO registerNewClient(@RequestBody ClientReqDTO client) {
        return service.registerNewClient(client);
    }

    public ClientResDTO getClientById(@PathVariable long id) {
        return service.getClientById(id);
    }

    public List<ClientResDTO> getAllClients() {
        return service.getAllClients();
    }

    public ClientResDTO updateUser(@RequestBody ClientReqDTO client) {
        return service.updateUser(client);
    }

    /*TODO alter this method to disableClientById*/
    public long deleteClientById(@PathVariable long id) {
        return service.deleteClientById(id);
    }
}
