package com.ewp.xprt.repository.interfaces;

import com.ewp.xprt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
