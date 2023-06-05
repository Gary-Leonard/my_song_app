package com.qa.data;

public class SongNotFoundException extends RuntimeException {

    public SongNotFoundException(int id) {
        super("Song with id '" + id + "' was not found.");
    }
}
