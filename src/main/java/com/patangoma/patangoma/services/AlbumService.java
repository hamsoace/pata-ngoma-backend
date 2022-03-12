package com.patangoma.patangoma.services;

import com.patangoma.patangoma.models.Album;
import com.patangoma.patangoma.models.Songs;
import com.patangoma.patangoma.repositories.AlbumRepository;
import com.patangoma.patangoma.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

    public void addAlbum(){
        albumRepository.save(new Album());
    }

    public List<Album> getAllAlbum(){
        return albumRepository.findAll();
    }

    public Album getAlbumBySongId(Long songId) {
        return albumRepository.findBySongId(songId);
    }

    public void createAlbum(Album album) {
        albumRepository.save(album);
    }

    public void updateAlbum(Album album) {
        albumRepository.save(album);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }

    public List<Songs> getAllSongsByAlbumName(String name) {

        List<Songs> songs = songRepository.findAllByAlbum(name);


        return songs;
    }


}
