package com.dxclogin.dxclogin.repository;

import com.dxclogin.dxclogin.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, UUID> {
    Optional<UsersModel> findByUsernameAndPassword(String username, String password);

    Optional<UsersModel> findByUsername(String username);
}
