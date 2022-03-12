package com.patangoma.patangoma.services;

import com.patangoma.patangoma.models.Album;
import com.patangoma.patangoma.models.Songs;
import com.patangoma.patangoma.repositories.AlbumRepository;
import com.patangoma.patangoma.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SongService {
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    @Autowired
    public SongService(SongRepository songRepository,
                       AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

    public void addSongs(){
        songRepository.saveSong(new Songs());
        songRepository.saveSong(new Songs());
        songRepository.saveSong(new Songs());
    }

    public List<Songs> getAllSongs(){
        return songRepository.getAllSongs();
    }

    public Songs getSongs(Long id){
        return songRepository.getSongs(id);
    }

    public void addSongs(Songs songs) {
        songRepository.saveSong(songs);
    }

    public void updateSong(Long id, Songs songs) {
        songs.setSongUpdateDate(new Timestamp(System.currentTimeMillis()));
        songRepository.updateSong(id, songs);
    }

    public void deleteSongs(Long id) {
        songRepository.deleteSongs(id);
    }

    public List<Album> getAlbums(Long id) {
        return songRepository.getAlbums(id);
    }

    public Album addAlbum(Long id, Album album) {
        albumRepository.addAlbum(id, album);
        return album;
    }

    public Album updateAlbum(Long id, Long albumId, Album album) {
        albumRepository.updateAlbum(albumId, album);
        return album;
    }

    public void deleteAlbum(Long id, Long albumId) {
        albumRepository.deleteAlbum(albumId);
    }

    public Album getAlbum(Long id, Long albumId) {
        return albumRepository.getAlbum(albumId);
    }
}
