package com.patangoma.patangoma.songs.services;

import com.patangoma.patangoma.songs.repositories.AlbumRepository;
import com.patangoma.patangoma.songs.repositories.SongRepository;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
}
