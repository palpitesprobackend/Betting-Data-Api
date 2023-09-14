package com.palpites.pro.api.bettingdata.dto.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
public class UserResponseDto {
    private String nome;
    private String email;
    @JsonIgnoreProperties
    private String createdAt;

    public String tojSON() {
        return (new Gson().toJson(this));
    }
}
