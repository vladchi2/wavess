package com.waveSounds.wavesApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends  JpaRepository<Song, Integer> {

    @Query("SELECT p FROM Song p WHERE p.song_name LIKE %?1%"
            + " OR p.album.album_name LIKE %?1%"
            + " OR p.playlist.playlist_name LIKE %?1%"
            + " OR CONCAT(p.id, '') LIKE %?1%")
    public List<Song> search(String keyword);
}
