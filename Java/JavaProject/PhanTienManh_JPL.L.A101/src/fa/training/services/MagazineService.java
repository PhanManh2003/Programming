package fa.training.services;

import fa.training.entities.Magazine;
import java.util.ArrayList;
import java.util.List;

public class MagazineService {

    private List<Magazine> magazines;

    public MagazineService() {
        this.magazines = new ArrayList<Magazine>();
    }

    public List<Magazine> getMagazines() {
        return magazines;
    }

    // 2.add a new magazine and keep them sorted by publication date
    public void addMagazine(Magazine magazine) {
        magazines.add(magazine);
        magazines.sort((m1, m2) -> m1.getPublicationDate().compareTo(
                m2.getPublicationDate()));
        System.out.println("Magazine added successfully.");
    }

    // 5.display top 10 magazines with largest volume
    public void displayTop10MagazinesByVolume() {
        magazines.stream()
                .sorted((m1, m2) -> Integer.compare(m2.getVolumn(), m1.getVolumn()))
                .limit(10)
                .forEach(Magazine::display);
    }

    // 6.Function to count all Publications by publication year
    public void countPublicationsByYear(int year) {
        long count = magazines.stream().filter(m -> m.getPublicationYear() == year).count();
        System.out.println("Number of magazines published in " + year + ": " + count);
    }

    // 3. Functional Req 3
    public void displayMagazinesByYearAndPublisher(int year, String publisher) {
        System.out.println("\nMagazines published in " + year + " by " + publisher + ":");
        boolean found = false;
        for (Magazine magazine : magazines) {
            if (magazine.getPublicationYear() == year && magazine.getPublisher().equalsIgnoreCase(publisher)) {
                magazine.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No magazines found with the given criteria.");
        }
    }

}
