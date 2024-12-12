package com.myRestaurant.manager.Controller;

import com.myRestaurant.manager.Dto.DishOrderDto;
import com.myRestaurant.manager.Payload.Request.DishOrderRequest;
import com.myRestaurant.manager.Payload.DishOrderResponse;
import com.myRestaurant.manager.Service.DishOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dishes")
public class DishesOrderController {

    @Autowired
    private DishOrderService dishOrderService;

    @GetMapping("/{tableId}")
    public String getDishesByTable(@PathVariable String tableId, Model model) {
        List<DishOrderDto> dishes = dishOrderService.getDishesByTable(tableId);
        model.addAttribute("dishes", dishes);
        model.addAttribute("tableId", tableId);
        return "dishesorder"; 
    }

    @PostMapping("/updateStatus")
    public DishOrderResponse updateDishStatus(@RequestBody DishOrderRequest request) {
        String message = dishOrderService.updateDishStatus(request);
        return new DishOrderResponse(message);
    }
}