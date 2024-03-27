package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@Autowired
	CarService carService;
	@Autowired
	CarDao carDao;

	@GetMapping("/cars")
	public String listCars(@RequestParam(required = false, defaultValue = "5") int count, Model model) {
		// Получаем весь список автомобилей
		List<Car> allCars = carDao.getAllCars();//было
		// Если count больше или равно размеру списка, возвращаем весь список
		if (count >= allCars.size()) {
			model.addAttribute("cars", allCars);
		} else {
			// В противном случае возвращаем подсписок из списка allCars
			List<Car> cars = allCars.subList(0, Math.min(count, allCars.size()));
			model.addAttribute("cars", cars);
		}
		return "cars";
	}
}