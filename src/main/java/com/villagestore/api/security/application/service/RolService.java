package com.villagestore.api.security.application.service;

import com.villagestore.api.security.domain.entity.Rol;
import com.villagestore.api.security.domain.enums.RolName;
import com.villagestore.api.security.infraestructure.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolName(RolName rolName) {
        return rolRepository.findByRolName(rolName);
    }

    public void save(Rol rol) {
        rolRepository.save(rol);
    }

}
