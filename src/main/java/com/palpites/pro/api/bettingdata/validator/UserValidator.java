package com.palpites.pro.api.bettingdata.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.palpites.pro.api.bettingdata.dto.users.UserRequestDto;
import com.palpites.pro.api.bettingdata.exceptions.ExceptionMessages;

@Component
public class UserValidator {

    public void validaDadosUsuario(UserRequestDto userRequestDto) {
        if (!validaEmail(userRequestDto.getEmail()))
            throw new ExceptionMessages(HttpStatus.BAD_REQUEST,
                    "Seu email está fora do padrão correto. Por favor, informe novamente.");

        if (!validaSenha(userRequestDto.getSenha()))
            throw new ExceptionMessages(HttpStatus.BAD_REQUEST,
                    "Sua senha deve conter letras maiusculas, minusculas e números.");

        if (!confirmaSenha(userRequestDto.getSenha(), userRequestDto.getConfirmaSenha()))
            throw new ExceptionMessages(HttpStatus.BAD_REQUEST,
                    "Você informou uma senha diferente da senha anterior.");
    }

    public boolean validaEmail(String email) {
        // Define uma expressão regular para validar emails
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        // Compila a expressão regular em um objeto Pattern
        Pattern pattern = Pattern.compile(regex);

        // Cria um objeto Matcher para a string de entrada
        Matcher matcher = pattern.matcher(email);

        // Verifica se a string corresponde à expressão regular
        return matcher.matches();
    }

    public boolean validaSenha(String senha) {
        // Verifica se a senha contém pelo menos uma letra maiúscula
        boolean contemMaiuscula = senha.matches(".*[A-Z].*");

        // Verifica se a senha contém pelo menos uma letra minúscula
        boolean contemMinuscula = senha.matches(".*[a-z].*");

        // Verifica se a senha contém pelo menos um número
        boolean contemNumero = senha.matches(".*\\d.*");

        // Retorna true se a senha atender a todos os critérios
        return contemMaiuscula && contemMinuscula && contemNumero;
    }

    public boolean confirmaSenha(String senha, String confirmaSenha) {
        return senha.equals(confirmaSenha);
    }
}
