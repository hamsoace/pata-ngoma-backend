package com.patangoma.patangoma.songs.controllers;

import com.patangoma.patangoma.songs.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/songs/album")
@CrossOrigin("*")
public class AlbumController {
    private final AlbumService albumService;

    @Autowired
}
