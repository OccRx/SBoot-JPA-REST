package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring.boot_security.demo.DAO.RoleDAO;
import ru.itmentor.spring.boot_security.demo.model.Role;
import java.util.List;

@Service
@Transactional
public class RoleServiceImp implements RoleService{

    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImp(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }

    @Override
    public Role findRoleById(long id) {
        return roleDAO.findRoleById(id);
    }

    @Override
    public void save(Role role) {
        roleDAO.save(role);
    }

    @Override
    public void update(Role role) {
        roleDAO.update(role);
    }

    @Override
    public void delete(long id) {
        roleDAO.delete(id);
    }
}