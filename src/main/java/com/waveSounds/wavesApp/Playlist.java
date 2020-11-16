package com.waveSounds.wavesApp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String playlist_name;
    //private int user_id ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(
            mappedBy = "playlist",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Song> playlist_songs = new ArrayList<>();



    public void setPlaylist_songs(List<Song> playlist_songs) {
        this.playlist_songs = playlist_songs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaylist_name() {
        return this.playlist_name;
    }

    public void setPlaylist_name(String playlist_name) {
        this.playlist_name = playlist_name;
    }

    //public int getUser_id() {       return user_id;    }

    //public void setUser_id(int user_id) { this.user_id = user_id; }

}
