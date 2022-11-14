package dio.myfirstwebapi.controller;

import dio.myfirstwebapi.model.User;
import dio.myfirstwebapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping()
    public List<User> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/{username}")
    public User getOne(String username) {
        return repository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    @PutMapping()
    public void putUser(@RequestBody User user){
        repository.save(user);
    }

    @PostMapping()
    public void postUser(@RequestBody User user) {
        repository.save(user);
    }

}
