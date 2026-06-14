package fa.training.services;

import fa.training.entities.Candidate;
import fa.training.entities.ExperienceCandidate;
import fa.training.entities.FresherCandidate;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Create 3 concurrent threads:
a. The first Thread to write a list of candidates into a text file.
b. The second thread to read all of the candidates from the file.
c. The third thread to display candidates by table format.


YÊU CẦU:
Storage Data:
a. The user inputs data from the keyboard.
b. Data is stored in a text file.
c. Output data is displayed on the console.
 */
public class CandidateService {

    private static final String FILE_PATH = "candidates.txt";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    static {
        DATE_FORMAT.setLenient(false);
    }

// Shared data list for candidates
    private List<Candidate> candidates;
    private final Object lock = new Object();

    public CandidateService() {
        this.candidates = new ArrayList<>();
    }

    /**
     * Add a candidate to the shared list
     */
    public void addCandidate(Candidate candidate) {
        synchronized (lock) {
            candidates.add(candidate);
        }
    }

    /**
     * Get all candidates from the shared list
     */
    public List<Candidate> getCandidates() {
        synchronized (lock) {
            return new ArrayList<>(candidates);
        }
    }

    /**
     * Write candidates to file with file locking
     */
    public void writeCandidatesToFile() {
        RandomAccessFile raf = null;
        FileChannel channel = null;
        FileLock fileLock = null;

        try {
            raf = new RandomAccessFile(FILE_PATH, "rw");
            channel = raf.getChannel();

            // Lock the file
            System.out.println("[Write Thread] Attempting to acquire file lock...");
            fileLock = channel.lock();
            System.out.println("[Write Thread] File lock acquired!");

            // Clear the file
            raf.setLength(0);

            // Write candidates
            synchronized (lock) {
                for (Candidate candidate : candidates) {
                    String line = candidateToString(candidate);
                    raf.writeBytes(line + "\n");
                }
            }

            System.out.println("[Write Thread] Successfully wrote " + candidates.size() + " candidates to file.");

            // Simulate some work
            Thread.sleep(1000);

        } catch (IOException | InterruptedException e) {
            System.err.println("[Write Thread] Error: " + e.getMessage());
        } finally {
            try {
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                    System.out.println("[Write Thread] File lock released!");
                }
                if (channel != null) {
                    channel.close();
                }
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                System.err.println("[Write Thread] Error closing resources: " + e.getMessage());
            }
        }
    }

    /**
     * Read candidates from file with file locking
     */
    public void readCandidatesFromFile() {
        RandomAccessFile raf = null;
        FileChannel channel = null;
        FileLock fileLock = null;

        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                System.out.println("[Read Thread] File does not exist yet. Waiting...");
                Thread.sleep(500);
                return;
            }

            raf = new RandomAccessFile(FILE_PATH, "r");
            channel = raf.getChannel();

            // Lock the file for reading
            System.out.println("[Read Thread] Attempting to acquire file lock...");
            fileLock = channel.lock(0, Long.MAX_VALUE, true); // Shared lock for reading
            System.out.println("[Read Thread] File lock acquired!");

            List<Candidate> readCandidates = new ArrayList<>();
            String line;

            while ((line = raf.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                Candidate candidate = parseCandidate(line);
                if (candidate != null) {
                    readCandidates.add(candidate);
                }
            }

            System.out.println("[Read Thread] Successfully read " + readCandidates.size() + " candidates from file.");

            // Update shared list
            synchronized (lock) {
                candidates.clear();
                candidates.addAll(readCandidates);
            }

            // Simulate some work
            Thread.sleep(1000);

        } catch (IOException | InterruptedException e) {
            System.err.println("[Read Thread] Error: " + e.getMessage());
        } finally {
            try {
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                    System.out.println("[Read Thread] File lock released!");
                }
                if (channel != null) {
                    channel.close();
                }
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                System.err.println("[Read Thread] Error closing resources: " + e.getMessage());
            }
        }
    }

    /**
     * Display candidates in table format
     */
    public void displayCandidatesInTable() {
        try {
            Thread.sleep(500); // Wait a bit for data to be ready

            synchronized (lock) {
                if (candidates.isEmpty()) {
                    System.out.println("[Display Thread] No candidates to display.");
                    return;
                }

                System.out.println("\n[Display Thread] Displaying candidates in table format:");
                System.out.println("================================================================================");
                System.out.println(String.format("%-15s %-15s %-12s %-20s %-15s %-25s %-20s",
                        "First Name", "Last Name", "Birth Date", "Address", "Phone", "Email", "Type/Details"));
                System.out.println("================================================================================");

                for (Candidate candidate : candidates) {
                    String birthDate = DATE_FORMAT.format(candidate.getBirthDate());
                    String details = "";

                    if (candidate instanceof ExperienceCandidate) {
                        ExperienceCandidate ec = (ExperienceCandidate) candidate;
                        details = "Exp: " + ec.getYearsExperience() + "y, " + ec.getProfessionalSkill();
                    } else if (candidate instanceof FresherCandidate) {
                        FresherCandidate fc = (FresherCandidate) candidate;
                        details = "Fresh: " + fc.getGraduationRank() + ", " + fc.getEducation();
                    }

                    System.out.println(String.format("%-15s %-15s %-12s %-20s %-15s %-25s %-20s",
                            candidate.getFirstName(),
                            candidate.getLastName(),
                            birthDate,
                            candidate.getAddress(),
                            candidate.getPhone(),
                            candidate.getEmail(),
                            details));
                }
                System.out.println("================================================================================");
                System.out.println("Total candidates: " + candidates.size());
            }
        } catch (InterruptedException e) {
            System.err.println("[Display Thread] Error: " + e.getMessage());
        }
    }

    /**
     * Convert candidate to string for file storage
     */
    private String candidateToString(Candidate candidate) {
        StringBuilder sb = new StringBuilder();
        sb.append(candidate.getFirstName()).append("|");
        sb.append(candidate.getLastName()).append("|");
        sb.append(DATE_FORMAT.format(candidate.getBirthDate())).append("|");
        sb.append(candidate.getAddress()).append("|");
        sb.append(candidate.getPhone()).append("|");
        sb.append(candidate.getEmail()).append("|");

        if (candidate instanceof ExperienceCandidate) {
            ExperienceCandidate ec = (ExperienceCandidate) candidate;
            sb.append("EXP|");
            sb.append(ec.getYearsExperience()).append("|");
            sb.append(ec.getProfessionalSkill());
        } else if (candidate instanceof FresherCandidate) {
            FresherCandidate fc = (FresherCandidate) candidate;
            sb.append("FRESH|");
            sb.append(DATE_FORMAT.format(fc.getGraduationDate())).append("|");
            sb.append(fc.getGraduationRank()).append("|");
            sb.append(fc.getEducation());
        }

        return sb.toString();
    }

    /**
     * Parse string to candidate object
     */
    private Candidate parseCandidate(String line) {
        try {
            String[] parts = line.split("\\|");
            if (parts.length < 7) {
                return null;
            }

            String firstName = parts[0];
            String lastName = parts[1];
            Date birthDate = DATE_FORMAT.parse(parts[2]);
            String address = parts[3];
            String phone = parts[4];
            String email = parts[5];
            String type = parts[6];

            if ("EXP".equals(type) && parts.length >= 9) {
                int yearsExperience = Integer.parseInt(parts[7]);
                String professionalSkill = parts[8];
                return new ExperienceCandidate(firstName, lastName, birthDate,
                        address, phone, email, yearsExperience, professionalSkill);
            } else if ("FRESH".equals(type) && parts.length >= 10) {
                Date graduationDate = DATE_FORMAT.parse(parts[7]);
                String graduationRank = parts[8];
                String education = parts[9];
                return new FresherCandidate(firstName, lastName, birthDate,
                        address, phone, email, graduationDate, graduationRank, education);
            }
        } catch (Exception e) {
            System.err.println("Error parsing candidate: " + e.getMessage());
        }
        return null;
    }

}
