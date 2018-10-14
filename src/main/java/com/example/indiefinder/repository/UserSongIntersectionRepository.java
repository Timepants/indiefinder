package com.example.indiefinder.repository;

import com.example.indiefinder.entities.UserSongIntersectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.sql.Timestamp;

public interface UserSongIntersectionRepository extends JpaRepository<UserSongIntersectionEntity, Long> {
    @Modifying
    @Query(
            nativeQuery = true,
            value = "insert into user_song_intersection (songID, userID, liked)\n" +
                    "    values\n" +
                    "      (:songID, :userID, :liked)"
    )
    @Transactional
    void create(@Param("songID") Integer songId, @Param("userID") Integer userId, @Param("liked") Byte liked);
}
