package com.kamkacz.car_rental.controller;

import com.kamkacz.car_rental.entity.Car;
import com.kamkacz.car_rental.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StartController {

    private CarService carService;

    public StartController(CarService theCarService) {
        carService = theCarService;
    }

    @GetMapping("/")
    public String showHome(Model theModel) {

        // get cars from db
        List<Car> theCars = carService.findAll();

        // add to the spring model
        theModel.addAttribute("cars", theCars);

        return "home";
    }
}
