package com.kamkacz.car_rental.service;

import com.kamkacz.car_rental.entity.Rental;
import com.kamkacz.car_rental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService{

    private RentalRepository rentalRepository;

    @Autowired
    public RentalServiceImpl(RentalRepository thRentalRepository) {
        rentalRepository = thRentalRepository;
    }

    @Override
    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental findById(int theId) {
        Optional<Rental> result = rentalRepository.findById(theId);

        Rental theRental = null;

        if (result.isPresent()) {
            theRental = result.get();
        } else {
            // Can't find the rental
            throw new RuntimeException("Did not find rental id - " + theId);
        }

        return theRental;
    }

    @Override
    public void save(Rental theRental) {
        Rental rental = new Rental();

        rentalRepository.save(theRental);
    }

    @Override
    public void deleteById(int theId) {
        rentalRepository.deleteById(theId);
    }

}
