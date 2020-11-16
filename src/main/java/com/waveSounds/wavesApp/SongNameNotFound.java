package com.waveSounds.wavesApp;

public class SongNameNotFound extends RuntimeException {
    SongNameNotFound(String name){
        super("Could not find song named " + name);
    }
}
