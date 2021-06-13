package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class UserDao {


    private final EntityManager entityManager;

    @Autowired
    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    public void addUser() {
//        entityManager.persist(new User("Ivan", "Ivanov", "Ivanov@yandex.ru"));
//    }

    public List<User> getAllUsers() {
        //addUser();
        //Query query = entityManager.createNamedQuery("User.getAll", User.class);
        return null;
    }
}
