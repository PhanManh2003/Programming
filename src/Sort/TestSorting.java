package Sort;

public class TestSorting {
    public static void main(String[] args) {
        int[] a = {1,5,3,2};
        System.out.println("before: "+ a);
        BubbleSort.bubbleSort(a);
        System.out.println("after: "+ a);

    }
}
