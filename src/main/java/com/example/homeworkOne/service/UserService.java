package com.example.homeworkOne.service;

import com.example.homeworkOne.entity.User;
import com.example.homeworkOne.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        User findUser = new User();
            if (this.userRepository.findById(id).isPresent()) {
                findUser = this.userRepository.findById(id).get();
            }
        return findUser;
    }

    public User addUser(User user) {
        User newUser = new User();

        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPhoneNumber(user.getPhoneNumber());
        return this.userRepository.save(newUser);

    }


    public void deleteUser(Long id) {

        this.userRepository.deleteById(id);
    }
}