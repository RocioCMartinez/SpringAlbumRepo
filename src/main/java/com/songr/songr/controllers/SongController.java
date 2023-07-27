package com.songr.songr.controllers;

import com.songr.songr.album.Album;
import com.songr.songr.album.Song;
import com.songr.songr.repositories.AlbumRepository;
import com.songr.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @PostMapping("/song/add")
    public RedirectView addSong(String title, float length, int trackNumber, String albumName){
        Album album = albumRepository.findByTitle(albumName);

        if(album == null){
            throw new IllegalArgumentException("Album " + albumName + " could not be found in records.");
        }

        Song song = new Song(title, length, trackNumber, album);
        songRepository.save(song);

        return new RedirectView("/albums/" + album.getId());
    }

    @GetMapping("/songs")
    public String showSongs(Model m)
    {
        List<Song> songs = songRepository.findAll();
        m.addAttribute("songs", songs);
        return "songs.html";
    }
}
