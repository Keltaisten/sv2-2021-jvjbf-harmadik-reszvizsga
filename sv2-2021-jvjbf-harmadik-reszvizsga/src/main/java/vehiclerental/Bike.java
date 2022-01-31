package vehiclerental;

import java.time.LocalTime;

public class Bike implements Rentable {
    private String id;
    private LocalTime rentingTime;
    private final static int PRICEPERMINUTE = 15;

    public Bike(String id) {
        this.id = id;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return (int) (minutes * PRICEPERMINUTE);
    }

    @Override
    public LocalTime getRentingTime() {
        return rentingTime;
    }

    @Override
    public void rent(LocalTime time) {
        rentingTime = time;
    }

    @Override
    public void closeRent() {
        rentingTime = null;
    }

//    @Override
//    public int compareTo(Rentable o) {
//        return 0;
//    }
}
