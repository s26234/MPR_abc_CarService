package mja.abc;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class CarService {
    private final CarStorage carStorage;
    private final RentalStorage rentalStorage;

    public CarService(CarStorage carStorage, RentalStorage rentalStorage) {
        this.carStorage = carStorage;
        this.rentalStorage = rentalStorage;
    }

    public List<Car> getAllCars() {
        return carStorage.getCarList();
    }

    public List<Rental> getAllRentals() {
        return rentalStorage.getRentalList();
    }

    private double calculation(long days, CarType carType) {
        double basePrice = 10;
        double multiplier = 10.5;

        if (carType.equals(CarType.STANDARD)) {
            return days * basePrice;
        } else {
            return days * basePrice * multiplier;
        }
    }

    //zwroc RentalInfo
    //do parametrow dodac LocalDate StartDate i EndDate
    public RentalInfo rentCar(User user, String vin, LocalDate startDate, LocalDate endDate) {
        Car car = carStorage.findCar(vin);
        List<Rental> rentalList = rentalStorage.getRentalList();

        if (car==null) {
            System.out.println("Numer vin nie isnieje");
            return null;
        }

        int days = 0;
        if (days < 0) {
            System.out.println("Data początkowa jest wieksza od końcowej");
            return null;
        }


        boolean wynajety = false;
        for (Rental rental : rentalList) {
            if (rental.getCar().getVin().equals(car.getVin())) {
                wynajety = true;
                break;
            }
        }

        if (wynajety) {
            System.out.println("Już jest zarezerwowany.");
        } else {
            rentalStorage.getRentalList().add(new Rental(user, car));
            System.out.println("Uzytkownik: " + user.getUser() + " wynajal: " + vin + "(" + car.getCarType() + ")");
            System.out.println("Ilosc dni: " + ChronoUnit.DAYS.between(startDate, endDate));
            System.out.println("Cena: " + calculation(ChronoUnit.DAYS.between(startDate, endDate), car.getCarType()));
        }

      //  return null;
        return new RentalInfo(calculation(days, car.getCarType()), startDate, endDate);
    }

    public void rentCar(String accName, String vin) {
        for (Car car : getAllCars()) {
            if (car.getVin().equals(vin)) {
                for(Rental rental : getAllRentals()) {
                if (rental.getCar().getVin().equals(vin)) {
                        System.out.println("Samochod jest niedostepny");
                    }
                        else {
                            rentalStorage.getRentalList().add(new Rental(new User(accName),car));
                            return;
                        }
                    }
                }
            }
        }
}

