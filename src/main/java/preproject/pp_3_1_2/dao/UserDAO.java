package preproject.pp_3_1_2.dao;

import preproject.pp_3_1_2.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    void saveUser(User user);
    User getUserById(int id);
    void update(int id, User user);
    void delete(int id);
}
