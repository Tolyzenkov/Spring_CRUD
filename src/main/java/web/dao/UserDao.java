package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void addUser(User user) {
        entityManager.persist(user);
    }

    public List<User> getAllUsers() {
        Query query = entityManager.createNamedQuery("User.getAll", User.class);
        return query.getResultList();
    }

    public User getUser(long id) {
        return getAllUsers().stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void update(User user, long id) {
        getUser(id).setFirstName(user.getFirstName());
        getUser(id).setLastName(user.getLastName());
        getUser(id).setEmail(user.getEmail());
        entityManager.refresh(getUser(id));
    }
}
