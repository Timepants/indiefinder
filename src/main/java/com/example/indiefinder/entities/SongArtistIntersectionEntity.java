package com.example.indiefinder.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "song_artist_intersection", schema = "indiefind", catalog = "")
public class SongArtistIntersectionEntity {
    private int songId;
    private int artistId;

    @Id
    @Column(name = "songID")
    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    @Id
    @Column(name = "artistID")
    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongArtistIntersectionEntity that = (SongArtistIntersectionEntity) o;
        return songId == that.songId &&
                artistId == that.artistId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(songId, artistId);
    }
}
