package com.myRestaurant.manager.Entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class InvoiceMenuKey implements Serializable {
    @Column(name = "invoice_id")
    private int invoiceId;
    
    @Column(name = "dish_id")
    private int dishId;
    
    public InvoiceMenuKey() {};
    
    public InvoiceMenuKey(int invoiceId, int dishId) {
    	this.invoiceId = invoiceId;
    	this.dishId = dishId;
    }
}