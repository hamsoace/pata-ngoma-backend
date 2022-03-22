package com.patangoma.patangoma.repositories;

import com.patangoma.patangoma.models.Album;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Qualifier("albums")
@Repository
public class AlbumRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void deleteById(Long id){
        entityManager.remove(entityManager.find(Album.class, id));
    }

    @Transactional
    public void save(Album album) {
        entityManager.persist(album);
    }

    @Transactional
    public List<Album> findAll() {
        return entityManager.createQuery("Select albums from Album albums", Album.class).getResultList();
    }

    @Transactional
    public Album findBySongId(Long songId) {
        return entityManager.find(Album.class, songId);
    }

    public void addAlbum(Long id, Album album) {
        album.setSongId(id);
        entityManager.persist(album);
    }

    public void updateAlbum(Long albumId, Album album) {
        Album album1 = entityManager.find(Album.class, albumId);
        if (album1 != null && album1.getAlbumName() != null) {
            album1.setAlbumName(album.getAlbumName());
        }
        if (album.getAlbumDescription() != null) {
            album1.setAlbumDescription(album.getAlbumDescription());
        }
        entityManager.persist(album1);
    }

    public void deleteAlbum(Long albumId) {
        Album productCategory = entityManager.find(Album.class, albumId);
        if (productCategory != null) {
            entityManager.remove(productCategory);
        }
    }

    public Album getAlbum(Long albumId) {
        return entityManager.find(Album.class, albumId);
    }
}
