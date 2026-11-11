package lw04.unguided;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("parcels.txt"));

        int n = input.nextInt();
        int[] parcels = new int[n];
        for (int i = 0; i < n; i++) {
            parcels[i] = input.nextInt();
        }

        int m = input.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = input.nextInt();
        }

        int[] afterTwo = new int[n];
        bubbleSort(parcels, afterTwo);

        System.out.println("==== After 2 Passes ====");
        printArray(afterTwo);
        System.out.println("==== Fully Sorted ====");
        printArray(parcels);

        System.out.println("==== Search Results ====");
        for (int i = 0; i < m; i++) {
            cariTarget(parcels, targets[i]);
        }
    }

    static void bubbleSort(int[] data, int[] salinan) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (data[j] < data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
            if (i == 1) {
                for (int k = 0; k < n; k++) {
                    salinan[k] = data[k];
                }
            }
        }
    }

    static void cariTarget(int[] data, int target) {
        int low = 0, high = data.length - 1, steps = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            steps++;
            if (data[mid] == target) {
                System.out.println(target + ": FOUND at index " + mid + " (steps: " + steps + ")");
                return;
            } else if (data[mid] > target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(target + ": NOT FOUND (steps: " + steps + ")");
    }

    static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            if (i < data.length - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
