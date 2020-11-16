package com.waveSounds.wavesApp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String album_name;
    //private int artist_id ;

    @OneToMany(
            mappedBy = "album",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Song> album_songs = new ArrayList<>();



    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToMany(
            mappedBy ="followed_albums"
    )
    private List<User> users = new ArrayList<>();
    /*ManyToOne
    @JoinColumn(name = "user_id")
    private User user;*/


    public void setAlbum_songs(List<Song> album_songs) {
        this.album_songs = album_songs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbum_name() {
        return this.album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    //public int getArtist_id() {return artist_id;    }

    //public void setArtist_id(int artist_id) { this.artist_id = artist_id; }

}
