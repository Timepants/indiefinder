package com.example.indiefinder.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "song_album_intersection", schema = "indiefind", catalog = "")
public class SongAlbumIntersectionEntity {
    private Integer songId;
    private Integer albumId;

    @Id
    @Column(name = "songID")
    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    @Id
    @Column(name = "albumID")
    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongAlbumIntersectionEntity that = (SongAlbumIntersectionEntity) o;
        return Objects.equals(songId, that.songId) &&
                Objects.equals(albumId, that.albumId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(songId, albumId);
    }
}
