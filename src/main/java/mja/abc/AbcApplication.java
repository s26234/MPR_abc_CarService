package mja.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@SpringBootApplication
@Component
public class AbcApplication {
	private final CarService carService;

	public AbcApplication (CarService carService) {
		this.carService = carService;
		// System.out.println(carService.getAllCars());
		carService.rentCar(new User("Adam"),"ddeeff", LocalDate.now(), LocalDate.of(2023,01,23));
	}

	public static void main(String[] args) {
		SpringApplication.run(AbcApplication.class, args);
	}
}

