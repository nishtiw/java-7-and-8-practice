package com.practice.search.service.impl;

import com.practice.search.entity.User;
import com.practice.search.repository.UserRepository;
import com.practice.search.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> searchUserByName(String query, Integer pageNumber, Integer pageSize, String sortProperty) {
        Pageable pageable = null;
        if(sortProperty.length() > 0) {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "name");
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "name");
        }
        List<User> users = userRepository.searchUserByName(query, pageable);
        return users;
    }
}
