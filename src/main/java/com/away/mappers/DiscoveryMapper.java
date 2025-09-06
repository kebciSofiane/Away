package com.away.mappers;

import com.away.db.models.DiscoveryEntity;
import com.away.db.models.UserEntity;
import com.away.dto.createDto.CreateDiscoveryDto;
import com.away.dto.createDto.CreateUserDto;
import com.away.dto.responseDto.ResponseDiscoveryDto;
import com.away.dto.responseDto.ResponseUserDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface DiscoveryMapper {

    DiscoveryEntity toDiscoveryEntity(CreateDiscoveryDto dto);

    ResponseDiscoveryDto toResponseDiscoveryDTO(DiscoveryEntity entity);
}
