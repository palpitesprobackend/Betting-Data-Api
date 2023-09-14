package com.palpites.pro.api.bettingdata.dto.users;

import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserRequestDto {

//    @NotBlank(message = "O campo [nome] é obrigatório")
//    @Length(min = 3, max = 50, message = "O campo nome deve ter entre 3 e 50 caracteres")
    private String nome;
//    @NotBlank(message = "O campo [email] é obrigatório")
    private String email;
//    @NotBlank(message = "O campo [senha] é obrigatório")
//    @Length(min = 6, max = 12, message = "O campo [senha] deve ter entre 6 e 12 caracteres")
    private String senha;
    private String confirmaSenha;
}
