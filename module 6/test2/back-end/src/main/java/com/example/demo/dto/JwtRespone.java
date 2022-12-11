package com.example.demo.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtRespone {

    private Integer id;
    private String token;
    private String type = "Bearer";
    private String name;
    private Collection<? extends GrantedAuthority> roles;

    public JwtRespone() {
    }

    public JwtRespone(Integer id, String token, String type, String name, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.token = token;
        this.type = type;
        this.name = name;
        this.roles = roles;
    }

    public JwtRespone(String token, String username, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.name = username;
        this.roles = authorities;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
