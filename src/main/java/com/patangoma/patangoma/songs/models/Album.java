package com.patangoma.patangoma.songs.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "albums")
public class Album {
    private static final AtomicInteger lastGeneratedId = new AtomicInteger(0);
    @Id
    private long albumId;
    private long songId;
    private String albumName;
    @Column(columnDefinition = "TEXT")
    private String albumDescription;

    public Album(){
        albumId = getNextAlbumId();
    }

    public Album(long songId, String albumName, String albumDescription){
        this.albumId = getNextAlbumId();
        this.songId = songId;
        this.albumName = albumName;
        this.albumDescription = albumDescription;
    }

    public Album(String albumName, String albumDescription){
        this.albumId = getNextAlbumId();
        this.albumName = albumName;
        this.albumDescription = albumDescription;
    }

    private static int getNextAlbumId() {
        return lastGeneratedId.incrementAndGet();
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public long getSongId() {
        return songId;
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }
}
