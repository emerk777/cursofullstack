package com.example.cursofullstack.dao;

import com.example.cursofullstack.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void remove(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void register(User user) {
        entityManager.merge(user);
    }

    @Override
    public boolean verifyUserCredentials(User user) {
        String query = "FROM User WHERE email = :emailP AND password = :passwordP";
        List<String> credentials = entityManager.createQuery(query)
                .setParameter("emailP", user.getEmail())
                .setParameter("passwordP", user.getPassword())
                .getResultList();
        return !credentials.isEmpty();
    }
}
