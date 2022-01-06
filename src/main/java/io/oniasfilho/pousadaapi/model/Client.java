package io.oniasfilho.pousadaapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String last_name;
    private String cpf;
    private String rg;
    private String passport;
    private String rne;
    private LocalDate birth_date;
    @CreationTimestamp
    private LocalDate registration_date;
}


//    id serial,
//    name varchar,
//    last_name varchar,
//    cpf varchar,
//    rg varchar,
//    passport varchar,
//    rne varchar,
//    birth_date date,
//    registration_date date,