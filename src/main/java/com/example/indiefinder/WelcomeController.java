package com.example.indiefinder;

import com.example.indiefinder.entities.UserSongIntersectionEntity;
import com.example.indiefinder.entities.UserSongIntersectionLastplayedEntity;
import com.example.indiefinder.entities.funkySong;
import com.example.indiefinder.repository.AlbumRepository;
import com.example.indiefinder.repository.UserSongIntersectionLastplayedRepository;
import com.example.indiefinder.repository.UserSongIntersectionRepository;
import com.example.indiefinder.repository.funkySongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    @Autowired
    UserSongIntersectionLastplayedRepository lastplayedRepository;

    @Autowired
    UserSongIntersectionRepository userSongIntersectionRepository;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", message);
        return "welcome";
    }
    @RequestMapping("/test")
    public String test(Map<String, Object> model) {
        loadPlayer(model);
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

    @GetMapping("/downVote")
    public String downVote(Map<String, Object> model, @RequestParam String id) {
        userSongIntersectionRepository.create(Integer.parseInt(id), 1, (byte)0);
        loadPlayer(model);
        return "test";
    }

    @GetMapping("/upVote")
    public String upVote(Map<String, Object> model, @RequestParam String id) {
        userSongIntersectionRepository.create(Integer.parseInt(id), 1, (byte)1);
        loadPlayer(model);
        return "test";
    }

    private void loadPlayer(Map<String, Object> model){
        model.put("message", message);
        model.put("musHeader", musHeader);
        model.put("artHeader", artHeader);
        funkySong song = null;
        do {
            songer.setTheBoiz();
            song = songer.spGetSong();
        } while (song == null);
        lastplayedRepository.create(song.getSongId(), 1, new Timestamp(new Date().getTime()));


        model.put("songID", song.getSongId());
        model.put("songName", song.getNameOfSong());
        model.put("albumName", song.getAlbumName());
        model.put("artistName", song.getArtistName());
        if (song.getAlbumId() != 0){
            model.put("albumID", song.getAlbumId());
        } else {
            model.put("albumID", 1);
        }
    }
}