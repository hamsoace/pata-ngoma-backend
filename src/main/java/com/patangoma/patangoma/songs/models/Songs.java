package com.patangoma.patangoma.songs.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "Songs")
public class Songs {
    private static final AtomicInteger lastGeneratedId = new AtomicInteger(0);

    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Id
    private long songId;
    private String songName;
    private int defaultOption;
    @Column(columnDefinition = "TEXT")
    private String songDescription;
    private String songImage;
    private String songUrl;
    @Transient
    private List<Album> albums = new ArrayList<>();
    private Timestamp songUpdateDate;
    private Timestamp songCreateDate;
    private String songStatus;
    @Transient
    private String songType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Songs(){
        this.songId = getSongUniqueId();
        this.songUpdateDate = new Timestamp(System.currentTimeMillis());
        this.songCreateDate = new Timestamp(System.currentTimeMillis());
    }

    public Songs(String songName, String songUrl, String songDescription, String songImage, String songType){
        this.songId =getSongUniqueId();
        this.songName = songName;
        this.songUrl = songUrl;
        this.songDescription = songDescription;
        this.songImage = songImage;
        this.songUpdateDate = new Timestamp(System.currentTimeMillis());
        this.songCreateDate = new Timestamp(System.currentTimeMillis());
        this.songType = songType;
    }

    public Songs(String songName, int defaultOption, String songUrl, String songDescription, String songImage, String songType){
        this.songId =getSongUniqueId();
        this.songName = songName;
        this.songUrl = songUrl;
        this.defaultOption = defaultOption;
        this.songDescription = songDescription;
        this.songImage = songImage;
        this.songUpdateDate = new Timestamp(System.currentTimeMillis());
        this.songCreateDate = new Timestamp(System.currentTimeMillis());
        this.songType = songType;
    }

    private long getSongUniqueId() {
        return lastGeneratedId.incrementAndGet();
    }



    public long getSongId() {
        return songId;
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public int getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(int defaultOption) {
        this.defaultOption = defaultOption;
    }

    public String getSongDescription() {
        return songDescription;
    }

    public void setSongDescription(String songDescription) {
        this.songDescription = songDescription;
    }

    public String getSongImage() {
        return songImage;
    }

    public void setSongImage(String songImage) {
        this.songImage = songImage;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public Timestamp getSongUpdateDate() {
        return songUpdateDate;
    }

    public void setSongUpdateDate(Timestamp songUpdateDate) {
        this.songUpdateDate = songUpdateDate;
    }

    public Timestamp getSongCreateDate() {
        return songCreateDate;
    }

    public void setSongCreateDate(Timestamp songCreateDate) {
        this.songCreateDate = songCreateDate;
    }

    public String getSongStatus() {
        return songStatus;
    }

    public void setSongStatus(String songStatus) {
        this.songStatus = songStatus;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public void addAlbum(Album album) {
        this.albums.add(album);
    }

    public void removeAllAlbums() {
        this.albums.clear();
    }

    public void removeAlbum(Album album) {
        this.albums.remove(album);
    }

    public void removeAllAlbum() {
        this.albums.clear();
    }


    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Songs songs = (Songs) obj;
        return Objects.equals(songId, songs.songId);
    }

    @Override
    public  int hashCode(){
        return Objects.hash(songId);
    }

    @Override
    public String toString(){
        return "Songs{" +
                "songId='" + songId + '\'' +
                ", songName='" + songName + '\'' +
                ", songUrl='" + songUrl + '\'' +
                ", songDescription='" + songDescription + '\'' +
                ", songImage='" + songImage + '\'' +
                ", songAlbum=" + albums +
                ", songUpdateDate=" + songUpdateDate +
                ", songCreateDate=" + songCreateDate +
                ", songType='" + songType + '\'' +
                '}';
    }
}
