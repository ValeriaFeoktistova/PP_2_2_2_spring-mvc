package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Component// это репозиторий наверно? @Repository это надо прописать?
public class CarDaoImp implements CarDao {
    private List<Car> cars = new ArrayList<>();

    public CarDaoImp() {
        // Создаем список из 5 машин
        cars.add(new Car("Volkswagen", "Touareg", 2023));
        cars.add(new Car("Volkswagen", "Touareg", 2022));
        cars.add(new Car("Volkswagen", "Touareg", 2021));
        cars.add(new Car("Volkswagen", "Tiguan", 2020));
        cars.add(new Car("Volkswagen", "Tiguan", 2019));

    }

    @Override
    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);//это логика где >5 значит всё? это здесь не должно находиться?Я вообще не понимаю этот метод нужен?
    }

    @Override
    public List<Car> getCars(int count) {
        return cars.subList(0, Math.min(count, cars.size()));

    }
}
