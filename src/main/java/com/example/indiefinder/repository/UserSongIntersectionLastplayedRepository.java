package com.example.indiefinder.repository;

import com.example.indiefinder.entities.UserSongIntersectionLastplayedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.sql.Timestamp;

public interface UserSongIntersectionLastplayedRepository extends JpaRepository<UserSongIntersectionLastplayedEntity, Long> {
    @Modifying
    @Query(
            nativeQuery = true,
            value = "insert into user_song_intersection_lastplayed (songID, userID, datePlayed)\n" +
                    "    values\n" +
                    "      (:songID, :userID, :datePlayed)"
    )
    @Transactional
    void create(@Param("songID") Integer songId, @Param("userID") Integer userId, @Param("datePlayed")Timestamp time);
}
