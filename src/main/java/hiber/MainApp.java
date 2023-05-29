package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        User user1 = new User("Asiman", "Guliev", "asiman.guliev@Gmail.cpm");
        User user2 = new User("Zaur", "Tregulov", "zaur@Gmail.cpm");
        User user3 = new User("Neil", "Alishev", "neil@Gmail.cpm");
        Car car1 = new Car("BMW", 2323);
        Car car2 = new Car("Mercedes", 2321);
        Car car3 = new Car("Audi", 1144);
        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        carService.addCar(car1);
        carService.addCar(car2);
        carService.addCar(car3);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        System.out.println(carService.userByModelAndSeries("BMW", 2323));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }
        context.close();
    }
}
