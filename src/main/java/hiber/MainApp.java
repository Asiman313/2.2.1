package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Asiman", "Guliev", "asiman.guliev@Gmail.cpm");
        User user2 = new User("Zaur", "Tregulov", "zaur@Gmail.cpm");
        User user3 = new User("Neil", "Alishev", "neil@Gmail.cpm");
        Car car1 = new Car("BMW");
        Car car2 = new Car("Mercedes");
        Car car3 = new Car("Audi");
        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        userService.addCar(car1);
        userService.addCar(car2);
        userService.addCar(car3);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        System.out.println(userService.userByModelAndSeries("BMW", 1));

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
