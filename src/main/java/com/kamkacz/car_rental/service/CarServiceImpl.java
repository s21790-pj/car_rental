package com.kamkacz.car_rental.service;

import com.kamkacz.car_rental.entity.Car;
import com.kamkacz.car_rental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository theCarRepository) {
        carRepository = theCarRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAllByOrderByBrandAsc();
    }

    @Override
    public Car findById(int theId) {
        Optional<Car> result = carRepository.findById(theId);

        Car theCar = null;

        if (result.isPresent()) {
            theCar = result.get();
        } else {
            // Can't find the car
            throw new RuntimeException("Did not find car id - " + theId);
        }

        return theCar;
    }

    @Override
    public void save(Car theCar) {
        Car car = new Car();

        carRepository.save(theCar);
    }

    @Override
    public void deleteById(int theId) {
        carRepository.deleteById(theId);
    }

    @Override
    public List<Car> searchBy(String theName) {

        List<Car> result = null;

        if (theName != null && (theName.trim().length() > 0)) {
            result = carRepository.findByBrandContainsOrModelContainsAllIgnoreCase(theName, theName);
        }
        else {
            result = findAll();
        }

        return result;
    }
}
