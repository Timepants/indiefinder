package com.example.indiefinder.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_song_intersection", schema = "indiefind", catalog = "")
public class UserSongIntersectionEntity {
    private Integer userId;
    private Integer songId;
    private byte liked;

    @Id
    @Column(name = "userID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "songID")
    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    @Basic
    @Column(name = "liked")
    public byte getLiked() {
        return liked;
    }

    public void setLiked(byte liked) {
        this.liked = liked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSongIntersectionEntity that = (UserSongIntersectionEntity) o;
        return liked == that.liked &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(songId, that.songId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, songId, liked);
    }
}
