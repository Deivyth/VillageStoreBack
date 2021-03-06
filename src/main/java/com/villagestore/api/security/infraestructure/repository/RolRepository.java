package com.villagestore.api.security.infraestructure.repository;

import com.villagestore.api.security.domain.entity.Rol;
import com.villagestore.api.security.domain.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRolName(RolName rolName);
}
