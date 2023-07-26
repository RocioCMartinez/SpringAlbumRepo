package com.songr.songr.repositories;

import com.songr.songr.album.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    // default save(), delete(), update(), findAll()

    public Album findByTitle(String title);
}
