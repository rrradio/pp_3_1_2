package pp312.springBoot.service;

import pp312.springBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void saveUser(User user);
    User show(int id);
    void update(int id, User user);
    void delete(int id);
}
