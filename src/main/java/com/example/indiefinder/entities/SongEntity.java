package com.example.indiefinder.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "song", schema = "indiefind", catalog = "")
public class SongEntity {
    private int songId;
    private String nameOfSong;

    @Id
    @Column(name = "songID")
    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    @Basic
    @Column(name = "nameOfSong")
    public String getNameOfSong() {
        return nameOfSong;
    }

    public void setNameOfSong(String nameOfSong) {
        this.nameOfSong = nameOfSong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongEntity that = (SongEntity) o;
        return songId == that.songId &&
                Objects.equals(nameOfSong, that.nameOfSong);
    }

    @Override
    public int hashCode() {

        return Objects.hash(songId, nameOfSong);
    }
}
