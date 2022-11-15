package com.example.example.dto;

import com.example.example.entities.UserEntity;

public class UserDTO {
    private Long id;
    private String username;
    private String email;


    public static UserDTO toDTO(UserEntity entity){
        UserDTO dto = new UserDTO();

        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());

        return dto;
    }

    public UserDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
