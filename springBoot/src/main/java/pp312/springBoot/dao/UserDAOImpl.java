package pp312.springBoot.dao;

import org.springframework.stereotype.Repository;
import pp312.springBoot.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;



@Repository
public class UserDAOImpl implements UserDAO {

      @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    public User show(int id) {
        return getUsers().stream().filter(user -> user.getId() == id)
                .findAny().orElse(null);
    }

    @Override
    public void update(int id, User user) {
        User neew = show(id);
        neew.setName(user.getName());
        neew.setAge(user.getAge());
        entityManager.merge(neew);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(show(id));
    }


}
