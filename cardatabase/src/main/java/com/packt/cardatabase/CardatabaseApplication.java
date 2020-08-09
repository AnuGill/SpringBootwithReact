package com.packt.cardatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private CarRepository carRepo;
	
	@Autowired
	private OwnerRepository ownerRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Hello Spring Boot");
	}
	
	@Bean
	CommandLineRunner runner() {
		return args ->{
			
			Owner o1 = ownerRepo.save(new Owner("Anuveer", "Gill"));
			Owner o2 = ownerRepo.save(new Owner("Anu", "Kaur"));
			carRepo.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, o1));
			carRepo.save(new Car("Ford", "Mustang", "Red", "ADF-1123", 2019, 59000, o1));
			carRepo.save(new Car("Ford", "Mustang", "Red", "ADF-1125", 2020, 59000, o2));
			carRepo.save(new Car("Fiat", "someCar", "Black", "ADF-1195", 2014, 49000, o1));
			carRepo.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, o2));
			carRepo.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, o2));
			
			userRepo.save(new User("user", "$2y$12$cliVNdry46pnsMz1RfeZzOafLZaQlMwaN6AuetiZ0sALxR92TU9/e", "USER"));
			userRepo.save(new User("admin", "$2y$12$loxwWnXPsHrZuuJj2vpRLuYB9twxQVdI3NuuU5jVWZx3Gs2yt5YTy", "ADMIN"));
			
			
			//repo.getCarsInAscOrder("Ford").forEach(car -> System.out.println(car.getBrand() +" " +car.getYear()));
			
		};
	}
	

}
