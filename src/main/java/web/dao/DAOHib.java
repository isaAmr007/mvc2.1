package web.dao;

import web.model.User;

import java.util.List;

public interface DAOHib {
    void saveUser(User user);

    void updateUser(User user);

    User removeUserById(int id);

    List<User> getAllUsers();

    User getUserById(int id);
}
