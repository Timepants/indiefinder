package com.example.indiefinder;

import com.example.indiefinder.entities.funkySong;
import com.example.indiefinder.repository.AlbumRepository;
import com.example.indiefinder.repository.funkySongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomeController {
    // inject via application.yml
    private String message = "Hello World";

    @Value("${locations.song-url-header:test}")
    private String musHeader;

    @Value("${locations.album-art-url-header:test}")
    private String artHeader;

    @Autowired
    funkySongRepo songer;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", message);
        return "welcome";
    }
    @RequestMapping("/test")
    public String test(Map<String, Object> model) {
        model.put("message", message);
        model.put("musHeader", musHeader);
        model.put("artHeader", artHeader);
        funkySong song = null;
        do {
            songer.setTheBoiz();
            song = songer.spGetSong();
        } while (song == null);
        model.put("songID", song.getSongId());
        model.put("songName", song.getNameOfSong());
        model.put("albumName", song.getAlbumName());
        model.put("artistName", song.getArtistName());
        if (song.getAlbumId() != 0){
            model.put("albumID", song.getAlbumId());
        } else {
            model.put("albumID", 1);
        }
        return "test";
    }
    @RequestMapping("/index")
    public String index(Map<String, Object> model) {
        model.put("message", message);
        model.put("musHeader", musHeader);
        model.put("artHeader", artHeader);
        funkySong song = null;
        do {
            songer.setTheBoiz();
            song = songer.spGetSong();
        } while (song == null);
        model.put("songID", song.getSongId());
        model.put("songName", song.getNameOfSong());
        model.put("albumName", song.getAlbumName());
        model.put("artistName", song.getArtistName());
        if (song.getAlbumId() != 0){
            model.put("albumID", song.getAlbumId());
        } else {
            model.put("albumID", 1);
        }
        return "index";

    }


}