package com.sso.login.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色实体类
 */

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "role_name")
    private String roleName;

    @ManyToMany
    @JoinTable(name = "role_permission", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {@JoinColumn(name = "permission_id") })
    private Set<Permission> sysPermissions = new HashSet<>();

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permission> getSysPermissions() {
        return sysPermissions;
    }

    public void setSysPermissions(Set<Permission> sysPermissions) {
        this.sysPermissions = sysPermissions;
    }
}