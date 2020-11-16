package com.waveSounds.wavesApp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String user_name;
    private String user_pass;
    private String user_email;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Playlist> user_playlists = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "followedArtists",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<Artist> followed_artists = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "followedAlbums",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private List<Album> followed_albums = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "followedSongs",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Song> followed_songs = new ArrayList<>();

    public void setFollowed_artists(List<Artist> followed_artists) {
        this.followed_artists = followed_artists;
    }

    public void setFollowed_albums(List<Album> followed_albums) {
        this.followed_albums = followed_albums;
    }

    public void setFollowed_songs(List<Song> followed_songs) {
        this.followed_songs = followed_songs;
    }

    public void setUser_playlists(List<Playlist> user_playlists) {
        this.user_playlists = user_playlists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
