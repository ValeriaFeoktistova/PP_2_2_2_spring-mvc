package web.dao;
/*
Задание №2.2.2:
         Задание №2.2.2:
Коллекция должна находиться в ДАО, дао должно возвращать неизменяемые списки для того чтобы юзер не повлиял на нашу “базу” в виде коллекции.
Логика с “больше 5 значит все” должна находиться в UserServiceImpl.
count должен быть не обязательным параметром, после чего смотрится  есть ли  данный параметр

        Логика с “больше 5 значит все” должна находиться в UserServiceImpl.
        count должен быть не обязательным параметром, после чего смотрится  есть ли  данный параметр
*/

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component// это репозиторий наверно? @Repository это надо прописать?
public class CarDaoImp implements CarDao {
    private List<Car> cars;

    public CarDaoImp() {
        cars = new ArrayList<>();
        cars.add(new Car("Volkswagen", "Touareg", 2023));
        cars.add(new Car("Volkswagen", "Touareg", 2022));
        cars.add(new Car("Volkswagen", "Touareg", 2021));
        cars.add(new Car("Volkswagen", "Tiguan", 2020));
        cars.add(new Car("Volkswagen", "Tiguan", 2019));

    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }
}
