package com.erinc.Java6MovieMvc.mapper;

import com.erinc.Java6MovieMvc.mapper.dto.request.UserResgisterRequestDto;
import com.erinc.Java6MovieMvc.mapper.dto.response.LoginResponseDto;
import com.erinc.Java6MovieMvc.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE= Mappers.getMapper(IUserMapper.class);

    User toUser(final UserResgisterRequestDto dto);

    LoginResponseDto toLoginResponseDto(final User user);


}
