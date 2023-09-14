package com.palpites.pro.api.bettingdata.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_USER_ACCOUNT")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    //TODO:VERIFICAR SE O NOME PRECISA SER UNICO TBM
    @Column(unique = true)
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;

//    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private String createdAt;

//    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private String updatedAt;

    private boolean active;
}
