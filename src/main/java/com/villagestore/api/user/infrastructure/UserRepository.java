package com.villagestore.api.user.infrastructure;

import com.villagestore.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
