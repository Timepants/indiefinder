package com.example.indiefinder;

import com.example.indiefinder.repository.AlbumRepository;
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
    AlbumRepository albumRepository;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", message);
        return "welcome";
    }
    @RequestMapping("/test")
    public String test(Map<String, Object> model) {
//        model.put("id", albumRepository.findAll().get(0).getAlbumId());
//        model.put("name", albumRepository.findAll().get(0).getName());
        model.put("message", message);
        model.put("musHeader", musHeader);
        model.put("artHeader", artHeader);
        return "test";
    }
    @RequestMapping("/index")
    public String index(Map<String, Object> model) {
        model.put("message", message);
        model.put("musHeader", musHeader);
        model.put("artHeader", artHeader);

        return "index";

    }


}