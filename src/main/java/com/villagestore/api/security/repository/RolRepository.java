package com.villagestore.api.security.repository;

import com.villagestore.api.security.entity.Rol;
import com.villagestore.api.security.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRolName(RolName rolName);
}
