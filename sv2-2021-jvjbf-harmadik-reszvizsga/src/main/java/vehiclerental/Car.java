package vehiclerental;

import java.time.LocalTime;

public class Car implements Rentable{
    private String id;
    private LocalTime rentingTime;
    private final int PRICEPERMINUTE;

    public Car(String id, int PRICEPERMINUTE) {
        this.id = id;
        this.PRICEPERMINUTE = PRICEPERMINUTE;
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
