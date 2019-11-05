package com.ewp.xprt.service.impl;

import com.ewp.xprt.model.User;
import com.ewp.xprt.repository.interfaces.UserRepository;
import com.ewp.xprt.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User add(User entity) {
        return userRepository.saveAndFlush(entity);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void update(User entity) {
        userRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }


    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
