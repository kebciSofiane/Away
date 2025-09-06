package com.away.mappers;

import com.away.db.models.UserEntity;
import com.away.dto.createDto.CreateUserDto;
import com.away.dto.responseDto.ResponseUserDto;
import com.away.dto.updateDto.UpdateUserDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {


        UserEntity toUserEntity(CreateUserDto CreateUserDto);

        ResponseUserDto toResponseUserDTO(UserEntity userEntity);

        List<UserEntity> toUserEntityList(List<CreateUserDto> CreateUserDtos);

        List<ResponseUserDto> toResponseUserDTOList(List<UserEntity> userEntityList);

        @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
        void updateUserFromDto(UpdateUserDto dto, @MappingTarget UserEntity entity);

}
