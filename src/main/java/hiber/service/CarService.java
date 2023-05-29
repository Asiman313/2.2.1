package hiber.service;

import hiber.model.Car;
import hiber.model.User;

public interface CarService {

    void addCar(Car car);

    User userByModelAndSeries(String model, int series);
}
