package com.away.db.repositories;

import com.away.db.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

     UserEntity findByUserId(long id);
     UserEntity findByUserEmail(String email);
     Boolean existsByUserId(long id);
     Boolean existsByUserEmail(String email);

}
