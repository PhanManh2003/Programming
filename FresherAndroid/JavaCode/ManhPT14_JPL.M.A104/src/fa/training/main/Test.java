package fa.training.main;

import fa.training.entities.Song;
import fa.training.entities.Video;
import fa.training.management.MultimediaManagement;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        MultimediaManagement management = new MultimediaManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose function:");
            System.out.println(" 1. Add a new Video");
            System.out.println(" 2. Add a new Song");
            System.out.println(" 3. Show all multimedia");
            System.out.println(" 4. Exit");
            System.out.print("Your choice: ");
            choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1:
                    Video video = new Video();
                    video.createVideo();
                    management.addMultiMedia(video);
                    break;
                case 2:
                    Song song = new Song();
                    song.createSong();
                    management.addMultiMedia(song);
                    break;
                case 3:
                    management.displayMultiMedia();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        
        // đóng scanner
        scanner.close();
    }
}
