package demos.springdata.restdemo.service.impl;

import demos.springdata.restdemo.dao.UserRepository;
import demos.springdata.restdemo.model.User;
import demos.springdata.restdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("User with ID=%d not found!", id)));
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("User with Username=%s not found!", username)));
    }

    @Override
    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(Long id) {
        return null;
    }

    @Override
    public long getUsersCount() {
        return 0;
    }
}
