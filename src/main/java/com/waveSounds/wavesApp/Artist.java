package com.waveSounds.wavesApp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String artist_name;

    @OneToMany(
            mappedBy = "artist",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Album> artist_albums = new ArrayList<>();

    @ManyToMany(
            mappedBy ="followed_artists"

    )
    private List<User> users = new ArrayList<>();


    /*@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;*/

    public void setArtist_albums(List<Album> artist_albums) {
        this.artist_albums = artist_albums;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtist_name() {
        return this.artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }


}
