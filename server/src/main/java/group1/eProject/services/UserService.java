package group1.eProject.services;

import group1.eProject.entities.User;

public interface UserService {
    User login(String identifier, String password);
    User register(User user);
    User getById(int id);
    void delete(int id);
}