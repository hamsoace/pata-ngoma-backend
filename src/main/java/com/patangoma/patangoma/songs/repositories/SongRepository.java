package com.patangoma.patangoma.songs.repositories;

import com.patangoma.patangoma.songs.models.Album;
import com.patangoma.patangoma.songs.models.Songs;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
        List<Songs> songs = entityManager.createQuery("SELECT s FROM Songs s", Songs.class).getResultList();
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
        List<Album> albums = entityManager.createQuery("SELECT al FROM Album al", Album.class).getResultList();
        for (Album album : albums) {
            if (album.getSongId() == songs.getSongId()) {
                songs.addAlbum(album);
            }
        }
    }


    public void updateProduct(Long id, Product product) {
        Product productToUpdate = entityManager.find(Product.class, id);
        productToUpdate.setProductName(product.getProductName());
        productToUpdate.setProductImage(product.getProductImage());
        productToUpdate.setProductDescription(product.getProductDescription());
        entityManager.persist(productToUpdate);
    }

    public List<Album> getAlbums(Long id) {
        List<Album> albums = entityManager.createQuery("SELECT al FROM Album pc", Album.class).getResultList();
        List<Album> productCategoriesToReturn = new ArrayList<>();
        for (Album album : albums) {
            if (album.getSongId() == id) {
                albumsToReturn.add(album);
            }
        }
        return productCategoriesToReturn;
    }

    public List<Product> findAllByProductCategory(String name) {
        List<Product> products = entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        List<Product> productsToReturn = new ArrayList<>();
        for (Product product : products) {
            if(product.getProductType().equalsIgnoreCase(name)) {
                productsToReturn.add(product);
            }
        }
        return productsToReturn;
    }

}
