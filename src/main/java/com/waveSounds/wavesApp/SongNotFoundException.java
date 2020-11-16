package com.waveSounds.wavesApp;

public class SongNotFoundException extends RuntimeException {
    SongNotFoundException(int id){
        super("Could not find object with id: " + id);
    }

}

