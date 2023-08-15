package preproject.pp_3_1_2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import preproject.pp_3_1_2.model.User;

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

    public User getUserById(int id) {
        User user = getUsers().stream().filter(u -> u.getId() == id)
                .findFirst().orElse(null);
        if (user == null) {
            throw new NullPointerException("Пользователь с указанным id не найден");
        }
        return user;
    }

    @Override
    public void update(int id, User user) {
        User neew = getUserById(id);
        neew.setName(user.getName());
        neew.setAge(user.getAge());
        neew.setEmail(user.getEmail());
        entityManager.merge(neew);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getUserById(id));
    }


}
