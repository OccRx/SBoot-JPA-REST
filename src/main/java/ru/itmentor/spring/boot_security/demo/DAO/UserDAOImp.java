package ru.itmentor.spring.boot_security.demo.DAO;

import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.model.User;
import javax.persistence.*;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User newUser) {
        entityManager.merge(newUser);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public User findByName(String userName) {
        return entityManager.createQuery("""
                select u from User u join fetch u.authorities where u.name = :username
                """, User.class)
                .setParameter("username", userName)
                .getSingleResult();
    }
}
