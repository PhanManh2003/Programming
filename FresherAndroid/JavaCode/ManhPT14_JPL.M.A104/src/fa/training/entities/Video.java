package fa.training.entities;

public class Video extends Multimedia {

    public Video() {
    }

    public Video(String name, double duration) {
        super(name, duration);
    }

    public void createVideo() {
        System.out.println("----Enter video information------");
        super.createMultimedia();
    }

    @Override
    public String toString() {
        return String.format("Video:\t%-20s%.1f", getName(), getDuration());
    }

}
