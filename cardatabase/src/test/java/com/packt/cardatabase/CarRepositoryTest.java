package com.packt.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
class CarRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CarRepository carRepo;
	
	@Test
	public void saveCar() {
		Car car = new Car("Tesla", "Model X", "white", "ABC-1234", 2017, 86000, null);
		entityManager.persistAndFlush(car);
		assertThat(car.getBrand()).isNotNull();
	}
	
	
	@Test
	public void deleteCars() {
		entityManager.persistAndFlush(new Car("Tesla", "Model X", "white", "ABC-1234", 2017, 86000, null));
		entityManager.persistAndFlush(new Car("Mini", "Cooper", "red", "ABC-1234", 2017, 86000, null));
		carRepo.deleteAll();
		assertThat(carRepo.findAll()).isEmpty();
	}
	
	@Test
	public void saveCars() {
		Car car = new Car("Tesla", "Model X", "white", "ABC-1234", 2017, 86000, null);
		Car car2 = new Car("Toyota", "Model Y", "Red", "ABC-1234", 2020, 86000, null);
		entityManager.persistAndFlush(car);
		entityManager.persistAndFlush(car2);
		assertThat(car.getBrand()).isNotNull();
		assertThat(car2.getBrand()).isNotNull();
	}
	
}
