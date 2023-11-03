package web.DAO;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public User showUser(int id) {
        return entityManager.find(User.class,id);
    }
    @Override
    public void saveUser(User user) {
        if(user.getId() != 0) {
            entityManager.merge(user);
        } else {
            entityManager.persist(user);
        }
        entityManager.flush();
    }
    @Override
    public void delUser(int id) {
        entityManager.remove(showUser(id));
        entityManager.flush();
    }

}
