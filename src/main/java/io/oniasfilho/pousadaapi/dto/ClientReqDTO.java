package io.oniasfilho.pousadaapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ClientReqDTO {
    private long id;
    private String name;
    private String last_name;
    private String cpf;
    private String rg;
    private String passport;
    private String rne;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate birth_date;
}
