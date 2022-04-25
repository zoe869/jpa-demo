package edu.tus.jpademo.controllers;

import edu.tus.jpademo.dto.User;
import edu.tus.jpademo.exceptions.ResourceNotFoundException;
import edu.tus.jpademo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JpaDemoController
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String sayHi() {
        return "hello from jenkins test1";
    }
    
    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity< User > getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent())
            return ResponseEntity.ok().body(user.get());
        else
            throw new ResourceNotFoundException("User not found :: " + userId);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable(value = "id") Long userId){
        userRepository.deleteById(userId);
    }
}
