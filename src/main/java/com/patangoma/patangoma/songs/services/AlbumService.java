package com.patangoma.patangoma.songs.services;

import com.patangoma.patangoma.songs.models.Album;
import com.patangoma.patangoma.songs.repositories.AlbumRepository;
import com.patangoma.patangoma.songs.repositories.SongRepository;
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

    public List<Album> getAlbum(){
        return albumRepository.findAll();
    }


}
