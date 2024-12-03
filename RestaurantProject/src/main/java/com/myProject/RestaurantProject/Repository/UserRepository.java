package com.myProject.RestaurantProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myProject.RestaurantProject.Entities.UserEntities;

@Repository
public interface UserRepository extends JpaRepository<UserEntities, Integer>{
	List<UserEntities> findByUsernameAndPassword(String username, String password);
}
