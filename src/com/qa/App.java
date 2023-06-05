package com.qa;

import com.qa.data.InMemoryArrayListDAO;
import com.qa.data.InMemoryDAO;
import com.qa.data.Song;
import com.qa.data.SongDAO;

import java.time.LocalDate;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Song song1 = new Song(
                1, "Frog Prince", "Keane", 300,
                LocalDate.of(2006, 6, 12)
        );
        Song song2 = new Song(
                2, "Black Summer", "Red Hot Chilli Peppers", 250,
                LocalDate.of(2022, 2, 4)
        );
        Song song3 = new Song(
                3, "Con te partiro", "Andrea Boucelli", 250,
                LocalDate.of(1990, 6, 1)
        );
        Song[] data = new Song[] { song1, song2, song3 };
        SongApplication myApp = new SongApplication(
                new InMemoryArrayListDAO(data)
        );
        myApp.run();
    }
}
