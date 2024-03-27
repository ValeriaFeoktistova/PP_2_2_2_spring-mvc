package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService {
    @Autowired
    private CarDao carDao;

    private List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();//это метод разве нужен? ведь getCars может  возвращать всё
    }

    @Override
    public List<Car> getCars(int count) {
        return carDao.getCars(count);

    }
}

