package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.Collections;
import java.util.List;

@Service
public class CarServiceImp implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> getCars(int count) {
        // Получаем весь список автомобилей из CarDao
        List<Car> allCars = carDao.getAllCars();

        // Если count больше или равно размеру списка, возвращаем весь список
        if (count >= allCars.size()) {
            return Collections.unmodifiableList(allCars);
        } else {
            // В противном случае возвращаем подсписок из списка allCars
            List<Car> subList = allCars.subList(0, Math.min(count, allCars.size()));
            return Collections.unmodifiableList(subList);
        }
    }
}
