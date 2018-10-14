package com.example.indiefinder.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "song", schema = "indiefind", catalog = "")
public class SongEntity {
    private int songId;
    private String nameOfSong;
    private PublisherEntity publisher;


    List<AlbumEntity> albums = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "song_album_intersection",
            joinColumns = { @JoinColumn(name = "songID") },
            inverseJoinColumns = { @JoinColumn(name = "albumID") }
    )
    public List<AlbumEntity> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumEntity> albums) {
        this.albums = albums;
    }


    List<GenreEntity> genres = new ArrayList<>();
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "genre_song_intersection",
            joinColumns = { @JoinColumn(name = "songID") },
            inverseJoinColumns = { @JoinColumn(name = "genreID") }
    )
    public List<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreEntity> genres) {
        this.genres = genres;
    }


    private Set<ArtistEntity> artists = new HashSet<>();


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "song_artist_intersection",
            joinColumns = { @JoinColumn(name = "songID") },
            inverseJoinColumns = { @JoinColumn(name = "artistID") }
    )
    public Set<ArtistEntity> getArtists() {
        return artists;
    }

    public void setArtists(Set<ArtistEntity> artists) {
        this.artists = artists;
    }

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

    @ManyToOne(cascade = CascadeType.ALL)
    public PublisherEntity getPublisher() {
        return this.publisher;
    }

    public void setPublisher(PublisherEntity publisher) {
        this.publisher = publisher;
    }
}
