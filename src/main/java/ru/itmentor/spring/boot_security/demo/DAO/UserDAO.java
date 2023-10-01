package ru.itmentor.spring.boot_security.demo.DAO;

import ru.itmentor.spring.boot_security.demo.model.User;
import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User getUserById(long id);

    void save(User user);

    void update(User user);

    void delete(long id);

    User findByName(String userName);
}