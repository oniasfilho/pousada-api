package io.oniasfilho.pousadaapi.service.impl;

import io.oniasfilho.pousadaapi.dto.ClientReqDTO;
import io.oniasfilho.pousadaapi.dto.ClientResDTO;
import io.oniasfilho.pousadaapi.repository.ClientRepository;
import io.oniasfilho.pousadaapi.service.ClientService;
import io.oniasfilho.pousadaapi.utils.DBUtils;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.oniasfilho.pousadaapi.utils.DTOUtils.*;
@Service
public class ClientServiceImpl implements ClientService {

    ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    public ClientResDTO registerNewClient(ClientReqDTO client) {
        var incomingClient = clientReqDTO2Client(client);
        return client2ClientResDTO(repository.save(incomingClient));
    }

    public ClientResDTO getClientById(long id) {
        return client2ClientResDTO(repository.findById(id).get());
    }

    public List<ClientResDTO> getAllClients() {
        return listOfClientToListOfClientResDTO(repository.findAll());
    }

    public ClientResDTO updateUser(ClientReqDTO client) {
        var old = repository.findById(client.getId()).get();
        old = DBUtils.updateEntity(old, client);
        return client2ClientResDTO(repository.save(old));
    }

    public long deleteClientById(long id) {
        repository.deleteById(id);
        return id;
    }
}
