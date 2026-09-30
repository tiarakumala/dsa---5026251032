package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("washes.txt"));
        int washCount = sc.nextInt();
        MotorcycleWash[] MotorcycleWashes = new MotorcycleWash[washCount];

       for (int i = 0; i < washCount; i++) {
            String type = sc.next();
            String id = sc.next();
            int days = sc.nextInt();
            int units = sc.nextInt(); 

            if (type.equalsIgnoreCase("MOTORCYCLE")) {
                MotorcycleWashes[i] = new MotorcycleWash(id, days, units);
            } else if (type.equalsIgnoreCase("CAR")) {
                CarWash[] CarWashes = new CarWash[washCount];
                CarWashes[i] = new CarWash(id, days, units);
            }
        }
        sc.close();
    }
}