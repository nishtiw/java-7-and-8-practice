package com.practice.search.service;

import com.practice.search.entity.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {

    User addUser(User user);

    List<User> searchUserByName(String query, Integer pageNumber, Integer pageSize, String sortProperty);

}
