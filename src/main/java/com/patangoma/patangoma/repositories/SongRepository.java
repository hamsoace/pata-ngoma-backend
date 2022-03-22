package com.patangoma.patangoma.repositories;

import com.patangoma.patangoma.models.Album;
import com.patangoma.patangoma.models.Songs;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Qualifier("songs")
@Repository
public class SongRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Songs findById(Long id){
        return entityManager.find(Songs.class, id);
    }

    @Transactional
    public Songs getSongs(Long id){
        Songs songs = entityManager.find(Songs.class, id);
        getAlbum(songs);
        return songs;
    }

    @Transactional
    public List<Songs> getAllSongs() {
        //find all songs
        List<Songs> songs = entityManager.createQuery("SELECT songs FROM Songs songs", Songs.class).getResultList();
        for (Songs songs1 : songs) {
            getAlbum(songs1);
        }
        return songs;
    }

    @Transactional
    public Songs deleteSongs(Long id) {
        Songs songs = entityManager.find(Songs.class, id);
        entityManager.remove(songs);
        return songs;
    }

    @Transactional
    public void saveSong(Songs songs) {
        entityManager.persist(songs);
    }

    public void getAlbum(Songs songs) {
        List<Album> albums = entityManager.createQuery("SELECT albums FROM Album albums", Album.class).getResultList();
        for (Album album : albums) {
            if (album.getSongId() == songs.getSongId()) {
                songs.addAlbum(album);
            }
        }
    }


    public void updateSong(Long id, Songs songs) {
        Songs songsToUpdate = entityManager.find(Songs.class, id);
        songsToUpdate.setSongName(songs.getSongName());
        songsToUpdate.setSongImage(songs.getSongImage());
        songsToUpdate.setSongDescription(songs.getSongDescription());
        entityManager.persist(songsToUpdate);
    }

    public List<Album> getAlbums(Long id) {
        List<Album> albums = entityManager.createQuery("SELECT albums FROM Album pc", Album.class).getResultList();
        List<Album> albumsToReturn = new ArrayList<>();
        for (Album album : albums) {
            if (album.getSongId() == id) {
                albumsToReturn.add(album);
            }
        }
        return albumsToReturn;
    }

    public List<Songs> findAllByAlbum(String name) {
        List<Songs> songs = entityManager.createQuery("SELECT songs FROM Songs songs", Songs.class).getResultList();
        List<Songs> songsToReturn = new ArrayList<>();
        for (Songs song : songs) {
            if(song.getSongType().equalsIgnoreCase(name)) {
                songsToReturn.add(song);
            }
        }
        return songsToReturn;
    }

}
