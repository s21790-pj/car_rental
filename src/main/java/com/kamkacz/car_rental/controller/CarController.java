package com.kamkacz.car_rental.controller;

import com.kamkacz.car_rental.entity.Car;
import com.kamkacz.car_rental.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService theCarService) {
        carService = theCarService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listCars(Model theModel) {

        // get cars from db
        List<Car> theCars = carService.findAll();

        // add to the spring model
        theModel.addAttribute("cars", theCars);

        return "/cars/list-cars";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Car theCar = new Car();

        theModel.addAttribute("car", theCar);

        return "/cars/car-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("carId") int theId, Model theModel) {

        // get the car from the service
        Car theCar = carService.findById(theId);

        // set car as a model attribute to pre-populate the form
        theModel.addAttribute("car", theCar);

        // send over to our form
        return "/cars/car-form";
    }

    @GetMapping("/save")
    public String saveCar(@ModelAttribute("car") Car theCar) {

        // save the car
        carService.save(theCar);

        // use a redirect to prevent duplicate submissions
        return "redirect:/cars/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("carId") int theId) {

        // delete the car
        carService.deleteById(theId);

        // redirect to /cars/list
        return "redirect:/cars/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("carBrand") String theBrand, Model theModel) {

        List<Car> theCars = carService.searchBy(theBrand);

        theModel.addAttribute("cars", theCars);

        return "/cars/list-cars";
    }


}
