package mja.abc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarServiceTest {
    private final CarStorage carStorage = new CarStorage();
    private final RentalStorage rentalStorage = new RentalStorage();
    private final CarService carService = new CarService(carStorage, rentalStorage);
    private CarType carType;

    @Test
    void shouldNotFindCar()  {
        User user = new User("Adam");
        String vin = "abc" ;
        LocalDate startDate = LocalDate.of(2023, 12, 05);
        LocalDate endDate = LocalDate.of(2023, 12, 11);

        RentalInfo rentalInfo = carService.rentCar(user, vin, startDate, endDate);

        Assertions.assertNull(rentalInfo, "FAILED - vin jest w carstorage");
    }

    @Test
    void shouldNotRentCar_AleradyRented() {
        RentalInfo rentalInfo = carService.rentCar(new User("Adam"), "ddeeff", LocalDate.of(2023, 02, 01), LocalDate.of(2023,02,06));

        //THEN
        Assertions.assertNull(rentalInfo, "FAILED - auto wynajęte");
    }

    @Test
    void testStartToEndDate() {
        String vin = "aabbcc";
        LocalDate startDate = LocalDate.of(2022, 12, 10);
        LocalDate endDate = LocalDate.of(2022, 12, 15);

        RentalInfo rentalInfo = carService.rentCar(new User("Adam"), vin, startDate, endDate);

        Assertions.assertNull(rentalInfo);

    }

    @Test
    void shouldRentPremiumCar() {
        User user = new User("asdasds");
        String vin = "aabbcc";
        LocalDate startDate = LocalDate.of(2022, 12, 10);
        LocalDate endDate = LocalDate.of(2022, 12, 15);

        RentalInfo rentalInfo = carService.rentCar(user, vin, startDate, endDate);

        assertThat(rentalInfo.getPrice()).isEqualTo(50.0);
    }






/*
    @Test
    void Test() {
        //GIVEN
        LocalDate startDate = LocalDate.of(2022, 12, 10);
        LocalDate endDate = LocalDate.of(2022, 10, 12);

        //WHEN
        carService.rentCar(new User("polik"), "ddeeff", startDate, endDate);

        //THEN

        Assertions.assertNotNull(carService, "Brak VIN w CarStorage.");
    }
    */

}
