package ru.itmentor.spring.boot_security.demo.DAO;

import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.model.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAOImp implements RoleDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> findAll() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role findRoleById(long id) {
        return entityManager.find(Role.class,id);
    }

    @Override
    public void save(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(findRoleById(id));
    }
}