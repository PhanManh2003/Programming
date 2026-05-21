package fa.training.services;

import fa.training.entities.Magazine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MagazineService {

    private List<Magazine> magazines;

    public MagazineService() {
        this.magazines = new ArrayList<>();
    }

    /**
     * Add a magazine to the collection
     */
    public boolean addMagazine(Magazine magazine) {
        if (magazine == null) {
            return false;
        }

        magazines.add(magazine);
        return true;
    }

    /**
     * Get all magazines
     */
    public List<Magazine> getAllMagazines() {
        return new ArrayList<>(magazines);
    }

    /**
     * Get magazines by publication year and publisher  
     */
    public List<Magazine> getMagazinesByYearAndPublisher(int year, String publisher) {
        List<Magazine> results = new ArrayList<>();

        for (Magazine magazine : magazines) {
            if (magazine.getPublicationYear() == year
                    && magazine.getPublisher().equalsIgnoreCase(publisher)) {
                results.add(magazine);
            }
        }

        return results;
    }

    /**
     * Get top 10 magazines with the largest volume - KHÔNG DÙNG STREAM
     */
    public List<Magazine> getTop10MagazinesByVolume() {
        // Copy danh sách để sort
        List<Magazine> sortedMagazines = new ArrayList<>(magazines);

        // Sắp xếp theo volume giảm dần
        Collections.sort(sortedMagazines, new Comparator<Magazine>() {
            @Override
            public int compare(Magazine m1, Magazine m2) {
                // So sánh ngược lại để được thứ tự giảm dần
                return Integer.compare(m2.getVolume(), m1.getVolume());
            }
        });

        // Lấy 10 phần tử đầu tiên
        List<Magazine> top10 = new ArrayList<>();
        int count = Math.min(10, sortedMagazines.size());
        for (int i = 0; i < count; i++) {
            top10.add(sortedMagazines.get(i));
        }

        return top10;
    }

}
