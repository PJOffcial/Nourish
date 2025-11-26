package group1.eProject.api;

import group1.eProject.entities.User;
import group1.eProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserApi {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public User login(@RequestParam("identifier")String identifier, @RequestParam("password")String password) {
        return userService.login(identifier, password);
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User register(@RequestBody User user) {
        return userService.register(user);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        userService.delete(id);
    }
}