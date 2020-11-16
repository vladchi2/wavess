package com.waveSounds.wavesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepo;

    public List<Song> listAll(String keyword) {
        if (keyword != null) {
            return songRepo.search(keyword);
        }
        return songRepo.findAll();
    }
}
