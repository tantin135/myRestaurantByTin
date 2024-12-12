package com.myRestaurant.manager.Repository;

import com.myRestaurant.manager.Entities.InvoiceMenuEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceMenuRepository extends JpaRepository<InvoiceMenuEntities, Integer> {
	List<InvoiceMenuEntities> findByInvoiceEntities_TableId_TableId(String tableId);

}