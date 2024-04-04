package com.example.LHIND.dto;

import com.example.LHIND.helper.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {

    private int id;

    private String name;

    private String email;

    private String password;

    private Role role;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

}
