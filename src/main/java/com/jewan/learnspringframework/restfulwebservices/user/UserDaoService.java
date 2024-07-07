package com.jewan.learnspringframework.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    // JPA/Hibernate -> DataBase
    // UserDaoService -> Static List

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Jewan", LocalDate.now().minusYears(27)));
        users.add(new User(2, "TaekBae", LocalDate.now().minusYears(10)));
        users.add(new User(3, "ShoPo", LocalDate.now().minusYears(6)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }
}
