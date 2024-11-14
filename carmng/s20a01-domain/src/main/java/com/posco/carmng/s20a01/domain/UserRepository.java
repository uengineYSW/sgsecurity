package com.posco.carmng.s20a01.domain;

import com.posco.carmng.s20a01.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
