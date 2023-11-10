package com.dxclogin.dxclogin.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users_list")
public class UsersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID user_id;
    private String username;
    private String password;
    private ClearanceRoles clearance;

    // this constructor is for creating new instances
    public UsersModel(UUID user_id, String username, String password, ClearanceRoles clearance) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.clearance = clearance;
    }

    // this constructor is for creating instances when pulling data from database
    public UsersModel() {}

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClearanceRoles getClearance() {
        return clearance;
    }

    public void setClearance(ClearanceRoles clearance) {
        this.clearance = clearance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersModel that = (UsersModel) o;
        return Objects.equals(user_id, that.user_id) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && clearance == that.clearance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, username, password, clearance);
    }

    @Override
    public String toString() {
        return "UsersModel{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", clearance=" + clearance +
                '}';
    }
}
