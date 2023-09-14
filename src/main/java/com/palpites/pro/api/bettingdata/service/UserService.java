package com.palpites.pro.api.bettingdata.service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.palpites.pro.api.bettingdata.dto.users.UserRequestDto;
import com.palpites.pro.api.bettingdata.dto.users.UserResponseDto;
import com.palpites.pro.api.bettingdata.entity.UserEntity;
import com.palpites.pro.api.bettingdata.exceptions.ExceptionMessages;
import com.palpites.pro.api.bettingdata.repository.UserAccountRepository;
import com.palpites.pro.api.bettingdata.validator.UserValidator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserValidator userValidator;
    private final UserAccountRepository repository;

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        userValidator.validaDadosUsuario(userRequestDto);
        this.validaUserExist(userRequestDto);
        var save = repository.save(this.parseToEntity(userRequestDto));
        return parseToDto(save);
    }

    public ResponseEntity<Object> loginUserAccount(String nome, String email, String senha) {
        userValidator.validaEmail(email);
        UserEntity entity = repository.findByNomeAndEmail(nome, email)
                .orElseThrow(() -> new ExceptionMessages(HttpStatus.BAD_REQUEST, "USUÁRIO INEXISTENTE"));

        if (entity.isActive() && entity.getSenha().equals(senha)) {
            //TODO: ESTE RETORNO DEVERÁ SER UM TOKEN AUTHORIZATION para que o usuario informe em todos os demais endpoints
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NAO AUTORIZADO", HttpStatus.UNAUTHORIZED);
        }
    }

    public List<UserEntity> findAllUserAccount() {
        List<UserEntity> entityList = repository.findAll();
        return entityList;
    }
    private void validaUserExist(UserRequestDto userRequestDto) {
        if (repository.existsByNomeAndEmail(userRequestDto.getNome(), userRequestDto.getEmail()))
            throw new ExceptionMessages(HttpStatus.BAD_REQUEST, "Este usuario já existe");
    }

    private UserEntity parseToEntity(UserRequestDto userRequestDto) {
    return UserEntity.builder()
            .nome(userRequestDto.getNome())
            .email(userRequestDto.getEmail())
            //TODO: Pensar em como tornar a senha mais segura: tvz encodar na hora de salvar no banco
            .senha(userRequestDto.getSenha())
            .createdAt(ServicesUtils.getLocalDateTimeNow("dd/MM/yyyy HH:mm:ss"))
            .active(true)
            .build();
    }

    private UserResponseDto parseToDto(UserEntity entity) {
    return UserResponseDto.builder()
        .nome(entity.getNome())
        .email(entity.getEmail())
        .createdAt(entity.getCreatedAt())
        .build();
    }
}
