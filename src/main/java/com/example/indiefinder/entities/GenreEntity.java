package com.example.indiefinder.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "genre", schema = "indiefind", catalog = "")
public class GenreEntity {
    private int genreId;
    private String name;
    private Integer songId;

    @Id
    @Column(name = "genreID")
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
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
        GenreEntity that = (GenreEntity) o;
        return genreId == that.genreId &&
                Objects.equals(name, that.name) &&
                Objects.equals(songId, that.songId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(genreId, name, songId);
    }
}
