package com.songr.songr.repositories;

import com.songr.songr.album.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
