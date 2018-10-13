package com.example.indiefinder.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "genre_song_intersection", schema = "indiefind", catalog = "")
public class GenreSongIntersectionEntity {
    private Integer genreId;
    private Integer songId;

    @Id
    @Column(name = "genreID")
    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    @Id
    @Column(name = "songID")
    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreSongIntersectionEntity that = (GenreSongIntersectionEntity) o;
        return Objects.equals(genreId, that.genreId) &&
                Objects.equals(songId, that.songId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(genreId, songId);
    }
}
