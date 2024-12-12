package com.myRestaurant.manager.Service;

import com.myRestaurant.manager.Entities.MenuEntities;

import java.util.List;

public interface MenuService {
    List<MenuEntities> getMenuItemsByType(String type);
}