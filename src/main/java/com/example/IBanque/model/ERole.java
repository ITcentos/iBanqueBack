package com.example.IBanque.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.stream.Stream;


public enum ERole {
    ROLE_USER("U"),
    ROLE_Agent("A"),

    ROLE_ADMIN("AD") ;


    private String code;
    private ERole(String code) {
        this.code=code;
    }
    @JsonCreator
    public static ERole decode(final String code) {
        return Stream.of(ERole.values()).filter(targetEnum -> targetEnum.code.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getCode() {
        return code;
    }







}
