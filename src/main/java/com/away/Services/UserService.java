package com.away.Services;

import com.away.db.models.UserEntity;
import com.away.db.repositories.UserRepository;
import com.away.dto.createDto.CreateUserDto;
import com.away.dto.responseDto.ResponseUserDto;
import com.away.dto.updateDto.UpdateUserDto;
import com.away.exceptions.UserAlreadyExistsException;
import com.away.mappers.UserMapper;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private  final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }



    public List<ResponseUserDto> getAllUsers() {
        return userMapper.toResponseUserDTOList(userRepository.findAll());
    }

    public  ResponseUserDto getUserByEmail(String email) {
        return userRepository.findByUserEmail(email)
                .map(userMapper::toResponseUserDTO)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }

    public ResponseUserDto getUserByUserId(long userId) {
        UserEntity user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toResponseUserDTO(user);
    }

    public ResponseUserDto addUser(CreateUserDto createUserDto) {
        if (userRepository.existsByUserEmail(createUserDto.getUserEmail())) {
            throw new UserAlreadyExistsException("User already exists");
        }
        return  userMapper.toResponseUserDTO(userRepository.save(userMapper.toUserEntity(createUserDto)));
    }

    public ResponseUserDto updateUser(UpdateUserDto updatedUserDto, long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userMapper.updateUserFromDto(updatedUserDto, user);
                    UserEntity savedUser = userRepository.save(user);
                    return userMapper.toResponseUserDTO(savedUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(long userId) {
        UserEntity user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }






}
