package lw03.prelab.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) 
    {
        Set<String> registered = new HashSet<>();
        Scanner sc = new Scanner(Main.class.getResourceAsStream("registrations.txt"));

        while (sc.hasNextLine()) {
            registered.add(sc.nextLine());
        }
 
        Set<String> checkedIn = new HashSet<>();
        
        List<String> results = new ArrayList<>();
        int rejected = 0;
 
        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("checkins.txt")); {
            String id = sc2.nextLine();
 
            if (!registered.contains(id)) {
                results.add(id + ": Rejected (not registered)");
                rejected++;
            } else if (checkedIn.contains(id)) {
                results.add(id + ": Rejected (already checked in)");
                rejected--;
            } else {
                checkedIn.add(id);
                results.add(id + ": Checked in");
            }
        }
 
        System.out.println("===== Event Check-In Results =====");
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
 
        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + registered.size());
        System.out.println("Successful check-ins: " + checkedIn.size());
        System.out.println("Absent students: " + (registered.size() - checkedIn.size()));
        System.out.println("Rejected attempts: " + rejected);
        
        sc.close();
        sc2.close();
    }
    
}
