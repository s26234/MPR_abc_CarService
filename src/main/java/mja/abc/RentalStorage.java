package mja.abc;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class RentalStorage {
private List<Rental> rentalList = new ArrayList<>();

    public List<Rental> getRentalList() {
        return rentalList;
    }
    public RentalStorage() {
        rentalList.add(new Rental(new User("adam"), new Car("ford", "mondeo", "aabbcc", CarType.STANDARD)));
        rentalList.add(new Rental(new User("jan"), new Car("volkswagen", "touareg", "ddeeff", CarType.PREMIUM)));
    }
}