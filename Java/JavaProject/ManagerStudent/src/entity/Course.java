package entity;

public enum Course {
    JAVA("Java"),
    DOTNET(".Net"),
    C_CPP("C/C++");
    private String language;

    private Course(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public static Course getCourse(int type) {
        switch (type) {
            case 1:
                return JAVA;
            case 2:
                return DOTNET;
            case 3:
                return C_CPP;
            default:
                throw new AssertionError();
        }
    }

}
