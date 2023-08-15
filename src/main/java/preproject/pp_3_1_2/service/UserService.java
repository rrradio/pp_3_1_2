package preproject.pp_3_1_2.service;

import preproject.pp_3_1_2.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void saveUser(User user);
    User getUserById(int id);
    void update(int id, User user);
    void delete(int id);
}
