package com.example.indiefinder.repository;

import com.example.indiefinder.entities.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {
}
