package com.songr.songr.controllers;

import com.songr.songr.album.Album;
import com.songr.songr.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;

@Controller
public class AppController {

    @Autowired
    AlbumRepository albumRepository;
    @GetMapping("/")
    public String getSplashPage(){
        return "splash.html";
    }
    @GetMapping("/hello")
    public String getHelloWorld(){
        return "hello.html";
    }

    @GetMapping("/capitalize/{Input}")
    public String getCapitalizationWords(Model m, @PathVariable String Input){
        m.addAttribute("Input", Input.toUpperCase());
        return "capitalize.html";
    }

    @GetMapping("/albums")
    public String getAlbums(Model model){
        List<Album> albumCollection = albumRepository.findAll();
        Album album1 = new Album("Karma", "Taylor", 8, 721 );
        Album album2 = new Album("Dark Paradise", "Lana", 6, 582 );
        Album album3 = new Album("Happy Hour", "Michael", 10, 900 );
        albumCollection.add(album1);
        albumCollection.add(album2);
        albumCollection.add(album3);

        model.addAttribute("albums", albumCollection); // ChatGPT told me I needed to pass my albumCollection as an attribute value
        return "album-form.html";
    }

    @PostMapping("/albums")
    public RedirectView addAlbumFromForm(String title, String artist, Integer songCount, Integer length){
    Album newAlbum = new Album(title, artist, songCount, length);
    albumRepository.save(newAlbum);

    return new RedirectView("/");
    }
}
