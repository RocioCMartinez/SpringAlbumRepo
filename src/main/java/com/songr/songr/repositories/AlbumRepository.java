package com.songr.songr.repositories;

import com.songr.songr.album.Album;
import com.songr.songr.album.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    // default save(), delete(), update(), findAll()

    Album findByTitle(String title);
//    List<Song> findSongsById(long id);
}
