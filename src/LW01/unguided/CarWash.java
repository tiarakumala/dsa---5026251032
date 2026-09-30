package lw01.unguided;

public class CarWash extends WashService{
    public CarWash(String id, int days, int units) {
        super(id, days);
    }

    @Override
public int calculateCharge() {
    int baseCharge;

    if (getDays() <= 3) {
        baseCharge = getDays() * 35000;
    } else {
        baseCharge = (3 * 35000) + ((getDays() - 3) * 25000);
    }

    return baseCharge + 15000;
}

    @Override 
    public String label(){
        return "CAR";
    }
}
