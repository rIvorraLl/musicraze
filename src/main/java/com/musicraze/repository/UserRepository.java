package com.musicraze.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicraze.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
