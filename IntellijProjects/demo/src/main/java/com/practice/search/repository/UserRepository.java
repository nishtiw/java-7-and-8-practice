package com.practice.search.repository;

import com.practice.search.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.name LIKE CONCAT('%',:query,'%')")
    List<User> searchUserByName(String query, Pageable pageable);
}
