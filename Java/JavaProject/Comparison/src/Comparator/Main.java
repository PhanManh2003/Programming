package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 30));
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 40));
        people.add(new Person("Charlie", 35));

        // Sort the list based on the second letter of the names, then by age
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                String name1 = o1.getName();
                String name2 = o2.getName();

                // Check if names have at least two letters
                if (name1.length() >= 2 && name2.length() >= 2) {
                    // Extract the second letters
                    char secondLetter1 = name1.charAt(1);
                    char secondLetter2 = name2.charAt(1);

                    // Compare the second letters
                    int result = Character.compare(secondLetter1, secondLetter2);
                    if (result != 0) {
                        // If the second letters are different, return the result
                        return result;
                    } else {
                        // If the second letters are the same, compare by age
                        return Integer.compare(o1.getAge(), o2.getAge());
                    }
                }

                // If names have less than two letters, consider them equal
                return 0;
            }
        });

        // Print the sorted list of people
        System.out.println(people);
    }

    /*
    Character.compare(secondLetter2, secondLetter1) thay vì 
    Character.compare(secondLetter1, secondLetter2):
    điều này sẽ đảo ngược thứ tự sắp xếp theo chữ cái thứ hai.
    
Integer.compare(o2.getAge(), o1.getAge()) thay vì Integer.compare(o1.getAge(), o2.getAge()):
    điều này sẽ đảo ngược thứ tự sắp xếp theo tuổi.
     */
}
