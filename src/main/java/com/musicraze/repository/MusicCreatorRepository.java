package com.musicraze.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicraze.domain.MusicCreator;

public interface MusicCreatorRepository extends JpaRepository<MusicCreator, Long> {
}
