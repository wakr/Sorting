package javatutorials;

import java.util.Arrays;
import java.util.Scanner;

public class PaaOhjelma {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Kuinka monta lukua haluat syöttää: ");
        int[] a = new int[scanner.nextInt()];
        System.out.println("");
        System.out.print("Syötä sortattavat luvut välilyönnillä erotettuina (1 5 4...): ");
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println("...taulukko täynnä...");
        System.out.println("Taulukkosi: " + Arrays.toString(a));
        System.out.println("Järjestetään...");
        long timeNow = System.nanoTime();
        heapSort(a, a.length);
        System.out.println("Järjestetty: " + Arrays.toString(a));
        System.out.println("Aikaa kului: " + ((long)(System.nanoTime() - timeNow) / 1000) + " ms");

    }

    public static void heapSort(int[] a, int count) {
        heapify(a, count);

        int end = count - 1;

        while (end > 0) {
            swap(a, end, 0);
            end--;
            siftD(a, 0, end);
        }
    }

    private static void heapify(int[] a, int count) {

        int start = (count - 2) / 2;

        while (start >= 0) {
            siftD(a, start, count - 1);
            start--;
        }

    }

    private static void siftD(int[] a, int start, int end) {
        int root = start;

        while (root * 2 + 1 <= end) {
            int child = root * 2 + 1;

            if (child + 1 <= end && a[child] < a[child + 1]) {
                child++;
            }
            if (a[root] < a[child]) {
                swap(a, root, child);
                root = child;
            } else {
                return;
            }
        }
    }

    private static void swap(int[] a, int root, int child) {
        int valueOfRoot = a[root];
        a[root] = a[child];
        a[child] = valueOfRoot;
    }

}
