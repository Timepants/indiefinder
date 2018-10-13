package com.example.indiefinder.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_artist_intersection", schema = "indiefind", catalog = "")
public class UserArtistIntersectionEntity {
    private Integer userId;
    private Integer artistId;

    @Id
    @Column(name = "userID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "artistID")
    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserArtistIntersectionEntity that = (UserArtistIntersectionEntity) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(artistId, that.artistId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, artistId);
    }
}
