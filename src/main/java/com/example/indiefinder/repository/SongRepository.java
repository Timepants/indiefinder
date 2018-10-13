package com.example.indiefinder.repository;

import com.example.indiefinder.entities.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<SongEntity, Long> {
}
