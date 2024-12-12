package com.myRestaurant.manager.Service.Impl;

import com.myRestaurant.manager.Dto.DishOrderDto;
import com.myRestaurant.manager.Entities.InvoiceMenuEntities;
import com.myRestaurant.manager.Payload.Request.DishOrderRequest;
import com.myRestaurant.manager.Repository.InvoiceMenuRepository;
import com.myRestaurant.manager.Repository.MenuItemRepository;
import com.myRestaurant.manager.Service.DishOrderService;
import com.myRestaurant.manager.Entities.MenuEntities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DishOrderServiceImpl implements DishOrderService {

    @Autowired
    private InvoiceMenuRepository invoiceMenuRepository;

    @Autowired
    private MenuItemRepository menuEntitiesRepository;

    @Override
    public List<DishOrderDto> getDishesByTable(String tableId) {
        List<InvoiceMenuEntities> dishes = invoiceMenuRepository.findByInvoiceEntities_TableId_TableId(tableId);


        // Ánh xạ các món ăn và gán số thứ tự (index bắt đầu từ 1)
        return IntStream.range(0, dishes.size()) // Tạo stream các chỉ số
                .mapToObj(index -> {
                    InvoiceMenuEntities dish = dishes.get(index); // Lấy món ăn theo chỉ số
                    MenuEntities menu = dish.getMenuEntities(); // Lấy MenuEntities
                    return new DishOrderDto(
                            index + 1,  // STT: bắt đầu từ 1
                            menu.getDishName(),  // Tên món
                            dish.getQuantity(),  // Số lượng
                            dish.isDish_status() ? "Đã xong" : "Đang chờ"  // Trạng thái món ăn
                    );
                })
                .collect(Collectors.toList());
    }


    @Override
    public String updateDishStatus(DishOrderRequest request) {
        InvoiceMenuEntities dish = invoiceMenuRepository.findById(request.getDishId())
                .orElseThrow(() -> new RuntimeException("Dish not found"));
        dish.setDish_status(Boolean.parseBoolean(request.getStatus())); // Cập nhật trạng thái món
        invoiceMenuRepository.save(dish);
        return "Dish status updated successfully.";
    }
}