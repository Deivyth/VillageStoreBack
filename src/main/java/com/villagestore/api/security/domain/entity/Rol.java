package com.villagestore.api.security.domain.entity;

import com.villagestore.api.security.domain.enums.RolName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolName rolName;

    public Rol() {
    }

    public Rol(@NotNull RolName rolName) {
        this.rolName = rolName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RolName getRolName() {
        return rolName;
    }

    public void setRolName(RolName rolName) {
        this.rolName = rolName;
    }
}
