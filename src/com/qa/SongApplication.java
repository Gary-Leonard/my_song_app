package com.qa;

import com.qa.data.Song;
import com.qa.data.SongDAO;
import com.qa.data.SongNotFoundException;

import java.util.List;
import java.util.Scanner;

public class SongApplication {

    private SongDAO songDAO;
    private boolean isRunning;
    private Scanner scanner;

    public SongApplication(SongDAO dao) {
        this.songDAO = dao;
        scanner = new Scanner(System.in);
    }

    public void run() {
        // this is where the REPL begins, the app will spend most
        // of its time inside this loop
        isRunning = true;
        String input = null;

        while (isRunning) {
            printMenu();
            System.out.print("> ");
            input = scanner.nextLine();

            switch (input.toUpperCase()) {
                case "Q":
                    isRunning = false;
                    System.out.println("Goodbye");
                    break;
                case "R":
                    readAll();
                    break;
                case "I":
                    readById();
                    break;
                default:
                    System.out.println("Invalid command: " + input);
                    break;
            }
        }
    }

    private void readById() {
        boolean isDone = false;
        while (!isDone) {
            try {
                System.out.print("> ");
                Integer id = Integer.valueOf(scanner.nextLine());
                System.out.println(songDAO.readById(id));
                isDone = true;
            } catch (NumberFormatException e) {
                System.out.println("Sorry, only whole numbers are valid as ID's. Please try again!");
            } catch (SongNotFoundException e) {
                System.out.println(e.getMessage());
                isDone = true;
            }
        }
    }

    private void readAll() {
        List<Song> songs = songDAO.readAll();
        for (Song song : songs) System.out.println(song);
    }

    private void printMenu() {
        System.out.println("=== MENU ===");
        System.out.println("(R) Read all");
        System.out.println("(I) Read by id");
        System.out.println("(Q) Quit");
    }
}
