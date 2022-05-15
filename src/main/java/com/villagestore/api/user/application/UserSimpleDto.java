package com.villagestore.api.user.application;

public class UserSimpleDto {

    private Long id;
    private String name;

    public UserSimpleDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
