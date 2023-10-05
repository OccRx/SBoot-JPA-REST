package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import ru.itmentor.spring.boot_security.demo.model.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User findUserById(long id);

    void save(User user);

    void update(User user);

    void delete(long id);

    UserDetails loadUserByUsername(String userName);
}