package com.example.indiefinder.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_song_intersection_lastplayed", schema = "indiefind", catalog = "")
public class UserSongIntersectionLastplayedEntity {
    private Integer userId;
    private Integer songId;
    private Timestamp datePlayed;

    @Id
    @Column(name = "userID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "songID")
    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    @Basic
    @Column(name = "datePlayed")
    public Timestamp getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(Timestamp datePlayed) {
        this.datePlayed = datePlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSongIntersectionLastplayedEntity that = (UserSongIntersectionLastplayedEntity) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(songId, that.songId) &&
                Objects.equals(datePlayed, that.datePlayed);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, songId, datePlayed);
    }
}
