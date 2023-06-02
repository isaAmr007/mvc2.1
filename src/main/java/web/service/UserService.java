package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void updateUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();

    User getUserById(int id);
}
