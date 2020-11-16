package com.waveSounds.wavesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Convert;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8081" })
@RestController
class Controller {
    @Autowired
    SongRepository SongRepository;
    @Autowired
    UserRepository UserRepository;
    @Autowired
    ArtistRepository ArtistRepository;
    @Autowired
    AlbumRepository AlbumRepository;
    @Autowired
    PlaylistRepository PlaylistRepository;
    /*@Autowired
    private SongService song_service;*/

//SONG Related
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/songs")
    public List<Song> getAllSongs(){
        List<Song> songs = new ArrayList<>();
        SongRepository.findAll().forEach(songs :: add);
        return songs;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/songs/{id}")
    public Song getSongById(@PathVariable int id) {

        return SongRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
    }



    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/songs")
    public Song addSong(@RequestBody Song song){
        SongRepository.save(song);
        return song;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path = "/songs/{id}")
    public void deleteSong(@PathVariable int id){
        SongRepository.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path = "/songs/{id}")
    public Song replaceSong(@RequestBody Song newSong, @PathVariable int id) {

        return SongRepository.findById(id)
                .map(song -> {
                    song.setSong_name(newSong.getSong_name());
                    song.setArtist(newSong.getArtist());
                    return SongRepository.save(song);
                })
                .orElseGet(() -> {
                    newSong.setId(id);
                    return SongRepository.save(newSong);
                });
    }


 /*   @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/songs/{song_name}")
    public Song getSongByName(@PathVariable String song_name) {
        int flag = 0;
        for (Song song : SongRepository.findAll())
        {
            if(song.getSong_name().equals(song_name))
            {
                flag = 1;
                return song;

            }
        }
        throw new SongNameNotFound(song_name);


    }*/

   /* @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(path = "/songs/{song_name}")
    public String searchByName(Model model, @Param("song_name") String keyword) {
        List<Product> listProducts = service.listAll(keyword);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("keyword", keyword);

        return "index";
    }*/

    //USER related////////////////

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        UserRepository.findAll().forEach(users :: add);
        return users;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/users/{id}")
    public User getUserById(@PathVariable int id) {

        return UserRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/users")
    public User addUser(@RequestBody User user){
        UserRepository.save(user);
        return user;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id){
        UserRepository.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path = "/users/{id}")
    public User replaceUser(@RequestBody User newUser, @PathVariable int id) {

        return UserRepository.findById(id)
                .map(user -> {
                    user.setUser_name(newUser.getUser_name());
                    user.setUser_email(newUser.getUser_email());
                    user.setUser_pass(newUser.getUser_pass());

                    return UserRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return UserRepository.save(newUser);
                });
    }

    //ARTIST Related/////////////////////

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/artists")
    public Artist addArtist(@RequestBody Artist artist){
        ArtistRepository.save(artist);
        return artist;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/artists")
    public List<Artist> getAllArtists(){
        List<Artist> artists = new ArrayList<>();
        ArtistRepository.findAll().forEach(artists :: add);
        return artists;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/artists/{id}")
    public Artist getArtistById(@PathVariable int id) {

        return ArtistRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path = "/artists/{id}")
    public void deleteArtist(@PathVariable int id){
        ArtistRepository.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path = "/artists/{id}")
    public Artist replaceArtist(@RequestBody Artist newArtist, @PathVariable int id) {

        return ArtistRepository.findById(id)
                .map(artist -> {
                    artist.setArtist_name(newArtist.getArtist_name());
                    return ArtistRepository.save(artist);
                })
                .orElseGet(() -> {
                    newArtist.setId(id);
                    return ArtistRepository.save(newArtist);
                });
    }

    //ALBUM RELATED
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/albums")
    public Album addAlbum(@RequestBody Album album){
        AlbumRepository.save(album);
        return album;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/albums")
    public List<Album> getAllAlbums(){
        List<Album> albums = new ArrayList<>();
        AlbumRepository.findAll().forEach(albums :: add);
        return albums;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/albums/{id}")
    public Album getAlbumById(@PathVariable int id) {

        return AlbumRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path = "/albums/{id}")
    public void deleteAlbum(@PathVariable int id){
        AlbumRepository.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path = "/albums/{id}")
    public Album replaceAlbum(@RequestBody Album newAlbum, @PathVariable int id) {

        return AlbumRepository.findById(id)
                .map(album -> {
                    album.setAlbum_name(newAlbum.getAlbum_name());
                    return AlbumRepository.save(album);
                })
                .orElseGet(() -> {
                    newAlbum.setId(id);
                    return AlbumRepository.save(newAlbum);
                });
    }

    //PLAYLIST related

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/playlists")
    public Playlist addPlaylist(@RequestBody Playlist playlist){
        PlaylistRepository.save(playlist);
        return playlist;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/playlists")
    public List<Playlist> getAllPlaylists(){
        List<Playlist> playlists = new ArrayList<>();
        PlaylistRepository.findAll().forEach(playlists ::add);
        return playlists;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/playlists/{id}")
    public Playlist getPlaylistById(@PathVariable int id) {

        return PlaylistRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(path = "/playlists/{id}")
    public void deletePlaylist(@PathVariable int id){
        PlaylistRepository.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(path = "/playlists/{id}")
    public Playlist replacePlaylist(@RequestBody Playlist newPlaylist, @PathVariable int id) {

        return PlaylistRepository.findById(id)
                .map(playlist -> {
                    playlist.setPlaylist_name(newPlaylist.getPlaylist_name());
                    return PlaylistRepository.save(playlist);
                })
                .orElseGet(() -> {
                    newPlaylist.setId(id);
                    return PlaylistRepository.save(newPlaylist);
                });
    }
}
