package group1.eProject.imps;

import group1.eProject.entities.User;
import group1.eProject.repos.UserRepo;
import group1.eProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public User login(String identifier, String password) {
        return userRepo.login(identifier, password);
    }
    @Override
    public User register(User user) {
        userRepo.save(user);
        return userRepo.findById(user.getId())
                .orElseThrow(()->new RuntimeException("Account saving failed"));
    }
    @Override
    public User getById(int id) {
        return userRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));
    }
    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }
}