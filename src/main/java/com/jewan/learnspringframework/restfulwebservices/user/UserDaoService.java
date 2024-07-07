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
    private static Integer usersCount = 0;

    static {
        users.add(new User(++usersCount, "Jewan", LocalDate.now().minusYears(27)));
        users.add(new User(++usersCount, "TaekBae", LocalDate.now().minusYears(10)));
        users.add(new User(++usersCount, "ShoPo", LocalDate.now().minusYears(6)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
