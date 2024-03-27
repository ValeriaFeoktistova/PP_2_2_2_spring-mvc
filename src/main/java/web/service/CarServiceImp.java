package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CarServiceImp implements CarService {
    ////@Autowired
    //private CarDao carDao;
    @Override
    public List<Car> getAllCars() {//весь список
        return cars;
    }
    private List<Car> cars = new ArrayList<>();
    @Override
    public List<Car> getCars(int count) {
        if (count >= 5) {
            return Collections.unmodifiableList(cars);
        } else {
            List<Car> subList = cars.subList(0, Math.min(count, cars.size()));
            return Collections.unmodifiableList(subList);
        }
    }
}

