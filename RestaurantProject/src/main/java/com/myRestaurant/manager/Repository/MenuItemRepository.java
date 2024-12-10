package com.myRestaurant.manager.Repository;

import com.myRestaurant.manager.Entities.MenuEntities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuEntities, Integer> {
	List<MenuEntities> findByDishNameContainingIgnoreCase(String dishName);
}
