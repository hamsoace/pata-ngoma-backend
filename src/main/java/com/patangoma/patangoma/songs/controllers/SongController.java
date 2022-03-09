package com.patangoma.patangoma.songs.controllers;

import com.patangoma.patangoma.songs.models.Album;
import com.patangoma.patangoma.songs.models.Songs;
import com.patangoma.patangoma.songs.services.AlbumService;
import com.patangoma.patangoma.songs.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/songs")
@CrossOrigin("*")
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;

    @Autowired
    public SongController(SongService songService, AlbumService albumService){
        this.albumService = albumService;
        this.songService = songService;
    }

    @GetMapping
    public List<Songs> getAllSongs(){
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public Songs getSongs(@PathVariable("id") Long id){
        return songService.getSongs(id);
    }

    @PostMapping("/add")
    public void addSongs(@RequestBody Songs songs){
        songService.addSongs(songs);
    }

    @PutMapping("/update/{id}")
    public void updateSongs(@PathVariable("id") Long id, @RequestBody Songs songs){
        songService.updateSong(id, songs);
    }

    @DeleteMapping("delete/{id}")
    public void deleteSongs(@PathVariable("id") Long id){
        songService.deleteSongs(id);
    }

    @GetMapping("/{id}/album")
    public List<Album> getAlbums(@PathVariable("id") Long id){
        return songService.getAlbums(id);
    }

    @PostMapping("/{id}/album")
    public Album addAlbum(@PathVariable("id") Long id, @RequestBody Album album){
        return songService.addAlbum(id, album);
    }

    @PutMapping("/{id}/album/{albumId}")
    public Album updateAlbum(@PathVariable("id") Long id, @PathVariable("albumId") Long albumId, @RequestBody Album album){
      return songService.updateAlbum(id, albumId, album);
    }

    @DeleteMapping("/{id}/album/{albumId}")
    public void deleteAlbum(@PathVariable("id") Long id, @PathVariable("albumId") Long albumId){
        songService.deleteAlbum(id, albumId);
    }

    @GetMapping("/{id}/album/{albumId}")
    public Album getAlbumById(@PathVariable("id") Long id, @PathVariable("albumId") Long albumId){
        return songService.getAlbum(id, albumId);
    }

    public void addSongs(){
        albumService.addAlbum();
        songService.addSongs();
    }
}
