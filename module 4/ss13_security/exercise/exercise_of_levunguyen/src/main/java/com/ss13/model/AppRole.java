package com.ss13.model;

import javax.persistence.*;

@Entity
public class AppRole {

    @Id
    @GeneratedValue
    private Long roleId;

    private String roleName;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}