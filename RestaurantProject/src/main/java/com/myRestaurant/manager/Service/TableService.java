package com.myRestaurant.manager.Service;

import com.myRestaurant.manager.Dto.AreaDto;
import com.myRestaurant.manager.Dto.TableDto;
import com.myRestaurant.manager.Entities.AreaEntities;
import com.myRestaurant.manager.Entities.TableEntities;
import com.myRestaurant.manager.Repository.AreaRepository;
import com.myRestaurant.manager.Repository.TableRepository;
import com.myRestaurant.manager.Service.Impl.TableServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService implements TableServiceImpl{

	@Autowired
    private TableRepository tableRepository;

    @Autowired
    private AreaRepository areaRepository;
    
    @Override
    public TableEntities addTable(TableDto tableDto) {
        // Convert DTO to Entity
        TableEntities tableEntity = new TableEntities();
        tableEntity.setTableId(tableDto.getTable_id());
        tableEntity.setTableStatus(tableDto.isTable_status());
        tableEntity.setSeats(4);  // Assuming 4 seats by default, can be modified

        // Set the AreaEntity for the table
        AreaEntities areaEntities = areaRepository.findById(tableDto.getAreaDto().getArea_id()).orElse(null);
        if (areaEntities != null) {
            tableEntity.setAreaEntities(areaEntities);
        }

        return tableRepository.save(tableEntity);  // Save to database
    }
}
