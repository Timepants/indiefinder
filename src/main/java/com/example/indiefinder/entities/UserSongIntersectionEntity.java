package com.example.indiefinder.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "user_song_intersection", schema = "indiefind", catalog = "")
public class UserSongIntersectionEntity {
    private byte liked;

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
        return liked == that.liked;
    }

    @Override
    public int hashCode() {

        return Objects.hash(liked);
    }
}
