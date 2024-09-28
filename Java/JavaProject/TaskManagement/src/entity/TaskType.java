package entity;

public enum TaskType {
//    Mỗi hằng số enum có hai thuộc tính
 // Đối tượng CODE là một instance của enum TaskType.
    CODE(1, "Code"),
    TEST(2, "Test"),
    DESIGN(3, "Design"),
    REVIEW(4, "Review");
    private int id;
    private String name;

    private TaskType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TaskType getTaskTypeByID(int id) {
        switch (id) {
            case 1:
                return CODE;
            case 2:
                return TEST;
            case 3:
                return DESIGN;
            case 4:
                return REVIEW;
            default:
                throw new AssertionError();
        }
    }
    // getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
}
