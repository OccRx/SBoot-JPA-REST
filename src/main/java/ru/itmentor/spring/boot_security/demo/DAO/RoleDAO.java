package ru.itmentor.spring.boot_security.demo.DAO;

import ru.itmentor.spring.boot_security.demo.model.Role;
import java.util.List;

public interface RoleDAO {

    List<Role> findAll();

    Role findRoleById(long id);

    void save(Role role);

    void update(Role role);

    void delete(long id);
}