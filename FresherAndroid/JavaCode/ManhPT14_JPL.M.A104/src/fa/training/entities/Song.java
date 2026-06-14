package fa.training.entities;

import java.util.Scanner;

public class Song extends Multimedia {

    private String singer;

    // Default constructor
    public Song() {
    }

    // Constructor with 3 parameters
    public Song(String name, double duration, String singer) {
        super(name, duration);
        this.singer = singer;
    }

    //getter setter
    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    // create song
    public void createSong() {
        System.out.println("----Enter song information------");
        super.createMultimedia();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter singer: ");
        this.singer = scanner.nextLine();
    }

    @Override
    public String toString() {
        return String.format("Song:\t%-20s%.1f\t%s", getName(), getDuration(), singer);
    }
}
