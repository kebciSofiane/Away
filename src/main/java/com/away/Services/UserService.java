package com.away.Services;

import com.away.db.models.UserEntity;
import com.away.db.repositories.UserRepository;
import com.away.dto.createDto.CreateUserDto;
import com.away.dto.responseDto.ResponseUserDto;
import com.away.dto.updateDto.UpdateUserDto;
import com.away.exceptions.user.UserAlreadyExistsException;
import com.away.exceptions.user.UserNotFoundException;
import com.away.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private  final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    public List<ResponseUserDto> getAllUsers() {
        return userMapper.toResponseUserDTOList(userRepository.findAll());
    }

    public  ResponseUserDto getUserByEmail(String email) {
        return userRepository.findByUserEmail(email)
                .map(userMapper::toResponseUserDTO)
                .orElseThrow(()->  new UserNotFoundException(email));
    }

    public ResponseUserDto getUserByUserId(long userId) {
        UserEntity user = userRepository.findByUserId(userId)
                .orElseThrow(() ->  new UserNotFoundException(userId));
        return userMapper.toResponseUserDTO(user);
    }

    public ResponseUserDto addUser(CreateUserDto createUserDto) {
        if (userRepository.existsByUserEmail(createUserDto.getUserEmail())) {
            throw new UserAlreadyExistsException(createUserDto.getUserEmail());
        }

        UserEntity user = userMapper.toUserEntity(createUserDto);
        user.setUserPass(passwordEncoder.encode(createUserDto.getUserPass()));

        return  userMapper.toResponseUserDTO(userRepository.save(user));
    }

    public ResponseUserDto updateUser(UpdateUserDto updatedUserDto, long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    userMapper.updateUserFromDto(updatedUserDto, user);
                    UserEntity savedUser = userRepository.save(user);
                    return userMapper.toResponseUserDTO(savedUser);
                })
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public void deleteUser(long userId) {
        UserEntity user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        userRepository.delete(user);
    }






}
