package lw04;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int size = sc.nextInt();
        int values[] = new int[size];
        for(int i = 0; i < size; i++){
            values[i] = sc.nextInt();
        }

        for(int i = 1; i < 4; i++){
            int key = values[i];
            int j = i-1;
            while (j >= 0 && values[j] < key){
                values[j+1] = values[j];
                j = j-1;
            }
            values[j+1] = key;
        }
        for(int val : values){
            System.out.print(val + " ");
        }
        System.out.println();

        int targetSize = sc.nextInt();
        int target[] = new int[targetSize];

        for(int i = 0; i < targetSize; i++){
            target[i] = sc.nextInt();
        }

        for(int i = 0; i < targetSize; i++){
            int t = target[i];
            int idx = -1;
            for(int j = 0; j < size; j++){
                if(values[j] == t){
                    idx = j;
                }
            }
            if(idx != -1){
                System.out.println(t + ": FOUND at index " + idx);
            } else {
            System.out.println(t + ": NOT FOUND");
            }
        }
        
    }
}
