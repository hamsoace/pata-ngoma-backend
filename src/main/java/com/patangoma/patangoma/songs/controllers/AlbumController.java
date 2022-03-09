package com.patangoma.patangoma.songs.controllers;

import com.patangoma.patangoma.songs.models.Album;
import com.patangoma.patangoma.songs.models.Songs;
import com.patangoma.patangoma.songs.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs/album")
@CrossOrigin("*")
public class AlbumController {
    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService){
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> getAllAlbum(){
        return albumService.getAllAlbum();
    }

    @GetMapping("/{id}")
    public Album getAlbumBySongId(@PathVariable("id") Long albumId) {
        return albumService.getAlbumBySongId(albumId);
    }

    @PostMapping
    public void createAlbum(Album album) {
        albumService.createAlbum(album);
    }

    @DeleteMapping
    public void deleteAlbum(Long id) {
        albumService.deleteAlbum(id);
    }

    @PutMapping
    public void updateAlbum(@RequestBody Album album) {
        albumService.updateAlbum(album);
    }

    @GetMapping("/get")
    public List<Songs> getAllSongsByAlbumName(@RequestParam("name") String name) {
        return albumService.getAllSongsByAlbumName(name);
    }
}
