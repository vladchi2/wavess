package com.waveSounds.wavesApp;

import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String song_name;
    private String artist;
    //private int playlist_id;
    //private int album_id;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @ManyToMany(
            mappedBy ="followed_songs"
    )
    private List<User> users = new ArrayList<>();
    /*@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;*/

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getSong_name() {
        return this.song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    //public int getPlaylist_id() { return playlist_id;    }

    //public void setPlaylist_id(int playlist_id) {this.playlist_id = playlist_id;  }

    //public int getAlbum_id() { return album_id; }

    //public void setAlbum_id(int album_id) { this.album_id = album_id; }
}
