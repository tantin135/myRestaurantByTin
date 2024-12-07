package com.myRestaurant.manager.Controller;

import com.myRestaurant.manager.Dto.TableDto;
import com.myRestaurant.manager.Entities.TableEntities;
import com.myRestaurant.manager.Payload.ResponseData;
import com.myRestaurant.manager.Service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homepage-cashier")
public class AddtableController {

	@Autowired
    private TableService tableService;

    @PostMapping("/add-table")
    public ResponseEntity<?> addTable(@RequestBody TableDto tableDto) {
    	ResponseData responseData = new ResponseData();
        try {
            // Add table to the database using the service
            TableEntities savedTable = tableService.addTable(tableDto);

            // Prepare the response data
            responseData.setStatus(200);
            responseData.setDescription("Bàn đã được thêm thành công!");
            responseData.setData(savedTable);

            return ResponseEntity.ok(responseData);  // Return the structured response

        } catch (Exception e) {
            // Handle errors and send a response with the error message
            responseData.setStatus(500);
            responseData.setDescription("Có lỗi xảy ra khi thêm bàn.");
            responseData.setData(null);  // You can leave data as null in error cases

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(responseData);  // Return the error response with proper structure
        }
    }
}
