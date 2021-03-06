package io.oniasfilho.pousadaapi.service;

import io.oniasfilho.pousadaapi.dto.ClientReqDTO;
import io.oniasfilho.pousadaapi.dto.ClientResDTO;

import java.util.List;

public interface ClientService {
    public ClientResDTO registerNewClient(ClientReqDTO client);
    public ClientResDTO getClientById(long id);
    public List<ClientResDTO> getAllClients();
    public ClientResDTO updateUser(ClientReqDTO client);
    public long deleteClientById(long id);
}
