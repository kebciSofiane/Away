package com.away.Services;

import com.away.db.models.UserEntity;
import com.away.db.repositories.UserRepository;
import com.away.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public  UserEntity getUserByEmail(String email) {
        if (userRepository.existsByUserEmail(email)) {
            return userRepository.findByUserEmail(email);
        }
        else {
            /* TODO User doesn't exist*/
            return null;
        }
    }

    public UserEntity getUserByUserId(long userId) {
        if (userRepository.existsByUserId(userId)) {
            return userRepository.findByUserId(userId);
        }
        else {
            /* TODO User doesn't exist*/
            return null;
        }    }

    public UserEntity addUser(UserEntity userEntity) {
        if (!userRepository.existsByUserId(userEntity.getUserId())) {
            return  userRepository.save(userEntity);
        } else  {
            /* TODO Throw exception : User already exists*/
            return null;
        }
    }
    public UserEntity updateUser(UserEntity userEntity) {
        if (userRepository.existsByUserId(userEntity.getUserId())) {
            return  userRepository.save(userEntity);
        } else  {
            /*Todo Throw an Exception : user doesn't exist */
            return null;
        }
    }

    public void deleteUser(long userId) {
        if (userRepository.existsByUserId(userId)) {
             userRepository.deleteById(userId);
        } else {
            /*TODO Throw exception : User doesn't exist*/
        }
    }






}
