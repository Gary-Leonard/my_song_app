package com.qa.data;

import java.util.Arrays;

public class InMemoryDAO extends SongDAO {

    private Song[] data;

    public InMemoryDAO() {
        data = new Song[0];
    }

    public InMemoryDAO(Song[] data) {
        this.data = data;
    }

    @Override
    public Song[] readAll() {
        return data;
    }

    @Override
    public Song readById(int id) {
        for (Song song : data) {
            if (song.getId() == id) return song;
        }
        return null; // could be better to throw an exception
    }


    // Our save() method will update a song if it already
    // exists, otherwise it will save a new song to the array
    @Override
    public void save(Song song) {
        if (song.getId() <= 0) return; // don't save with invalid id
        Song existingSong = readById(song.getId());

        if (existingSong != null) { // update
            existingSong.setArtist(song.getArtist());
            existingSong.setRuntime(song.getRuntime());
            existingSong.setTitle(song.getTitle());
            existingSong.setReleaseDate(song.getReleaseDate());
        } else { // save new
            // song doesn't exist, save a new one
            data = Arrays.copyOf(data, data.length + 1);
            data[data.length - 1] = song;
        }

    }

    @Override
    public boolean deleteById(int id) {
        // TODO: Implement me!
        return super.deleteById(id);
    }
}
