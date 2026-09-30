package lw01.unguided;

public abstract class WashService implements Billable{
    private String id;
    private int days;

    protected WashService(String id, int days){
        this.id = id;
        this.days = days;
    }
 public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }
    
    @Override 
    public abstract int calculateCharge();

    //overload
    public int calculateCharge(int units){
        return units * calculateCharge();
    }

    public String label(){
        return "Service";
    }

    public String summary(){
        return id + " | " + label() + " | " + calculateCharge(); 
    }
}
