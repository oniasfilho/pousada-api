package io.oniasfilho.pousadaapi.utils;

import io.oniasfilho.pousadaapi.dto.ClientReqDTO;
import io.oniasfilho.pousadaapi.dto.ClientResDTO;
import io.oniasfilho.pousadaapi.model.Client;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DTOUtils {
    public static ClientResDTO client2ClientResDTO(Client c){
        return ClientResDTO.builder()
                .id(c.getId())
                .name(c.getName())
                .last_name(c.getLast_name())
                .cpf(c.getCpf())
                .rg(c.getRg())
                .passport(c.getPassport())
                .rne(c.getRne())
                .birth_date(c.getBirth_date())
                .build();
    }

    public static Client clientReqDTO2Client(ClientReqDTO c){
        return Client.builder()
                .name(c.getName())
                .last_name(c.getLast_name())
                .cpf(c.getCpf())
                .rg(c.getRg())
                .passport(c.getPassport())
                .rne(c.getRne())
                .birth_date(c.getBirth_date())
                .build();
    }

    public static List<ClientResDTO> listOfClientToListOfClientResDTO(List<Client> clients){
        var listOfClients = clients.stream().map(c -> {
                    return ClientResDTO.builder()
                            .id(c.getId())
                            .name(c.getName())
                            .last_name(c.getLast_name())
                            .cpf(c.getCpf())
                            .rg(c.getRg())
                            .passport(c.getPassport())
                            .rne(c.getRne())
                            .birth_date(c.getBirth_date())
                            .build();
        }
        ).collect(Collectors.toList());
        Collections.sort(listOfClients);
        return listOfClients;
    }
}
