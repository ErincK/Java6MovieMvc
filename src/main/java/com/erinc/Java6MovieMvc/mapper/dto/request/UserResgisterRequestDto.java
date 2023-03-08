package com.erinc.Java6MovieMvc.mapper.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResgisterRequestDto {
    String name;
    String surName;
    String password;
    String rePassword;
    String email;
}
