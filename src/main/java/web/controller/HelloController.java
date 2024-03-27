package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/cars")
	public String listCars(@RequestParam(required = false, defaultValue = "5") int count, Model model) {
		// Вызываем сервис для получения списка автомобилей
		List<Car> cars = carService.getCars(count);
		// Добавляем список автомобилей в модель для отображения в представлении
		model.addAttribute("cars", cars);
		// Возвращаем имя представления, которое будет использоваться для отображения списка автомобилей
		return "cars";
	}
}