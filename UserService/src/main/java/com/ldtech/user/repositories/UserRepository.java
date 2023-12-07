package com.ldtech.user.repositories;

import com.ldtech.user.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
