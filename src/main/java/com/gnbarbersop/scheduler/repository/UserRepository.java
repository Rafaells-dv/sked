package com.gnbarbersop.scheduler.repository;

import com.gnbarbersop.scheduler.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserDetails findByEmail(String email);
}
