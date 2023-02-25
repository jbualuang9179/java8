package data.structure.algorithm;

public class Main {

    public static void main(String[] args) {
        int n = 0;
        int total = 0;
        while (n != 20) {
            total += n;
            ++n;
            System.out.println("n : + " + n);
        } // end while
        System.out.println("sum = " + total);
    }
}
