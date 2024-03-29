package com.songr.songr.album;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Album {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            long id;
    String title;

    String artist;

    int songCount;

    double length;

    String imageUrl;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Song> songs;

    protected Album() {
    }

    public Album(String title, String artist, int songCount, double length) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Song> getAlbumSongs() {
        return songs;
    }

    public void setAlbumSongs(List<Song> albumSongs) {
        this.songs = albumSongs;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", songCount=" + songCount +
                ", length=" + length +
                ", imageUrl='" + imageUrl + '\'' +
                ", albumSongs=" + songs +
                '}';
    }
}
