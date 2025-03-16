package string;
// same as StringBuilder but synchronized

public class StringBufferGuide {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" ManhAlex");
        System.out.println(sb);
    }
}
