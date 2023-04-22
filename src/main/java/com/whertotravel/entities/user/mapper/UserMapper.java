package com.whertotravel.entities.user.mapper;

import com.whertotravel.entities.user.model.User;
import com.whertotravel.entities.user.model.UserCreateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  User userCreateRequestToUser(UserCreateRequest userCreateRequest);
}
