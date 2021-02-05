package com.kamkacz.car_rental.controller;

import com.kamkacz.car_rental.entity.Rental;
import com.kamkacz.car_rental.service.RentalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rentals")
public class RentalController {

    private RentalService rentalService;

    public RentalController(RentalService theRentalService) {
        rentalService = theRentalService;
    }

    @GetMapping("/list")
    public String listRentals(Model theModel) {

        List<Rental> theRentals = rentalService.findAll();

        theModel.addAttribute("rentals", theRentals);

        return "/rentals/list-rentals";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Rental theRental = new Rental();

        theModel.addAttribute("rental", theRental);

        return "/rentals/rental-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("rentalId") int theId, Model theModel) {

        Rental theRental = rentalService.findById(theId);

        theModel.addAttribute("rental", theRental);

        return "/rentals/rental-form";
    }

    @PostMapping("/save")
    public String saveRental(@ModelAttribute("rental") Rental theRental) {

        rentalService.save(theRental);

        return "redirect:/rentals/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("rentalId") int theId) {

        rentalService.deleteById(theId);

        return "redirect:/rentals/list";
    }

}
