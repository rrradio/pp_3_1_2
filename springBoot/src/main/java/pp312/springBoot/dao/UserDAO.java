package pp312.springBoot.dao;

import pp312.springBoot.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    void saveUser(User user);
    User show(int id);
    void update(int id, User user);
    void delete(int id);
}
