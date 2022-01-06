package io.oniasfilho.pousadaapi.utils;

import io.oniasfilho.pousadaapi.dto.ClientReqDTO;
import io.oniasfilho.pousadaapi.model.Client;

public class DBUtils {
    public static Client updateEntity(Client old, ClientReqDTO updated) {
        old.setName(updated.getName());
        old.setLast_name(updated.getLast_name());
        old.setCpf(updated.getCpf());
        old.setRg(updated.getRg());
        old.setPassport(updated.getPassport());
        old.setRne(updated.getRne());
        old.setBirth_date(updated.getBirth_date());
        return old;
    }
}
